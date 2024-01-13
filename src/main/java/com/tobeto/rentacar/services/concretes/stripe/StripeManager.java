package com.tobeto.rentacar.services.concretes.stripe;

import com.stripe.Stripe;
import com.stripe.model.Token;
import com.tobeto.rentacar.services.dtos.stripe.StripeChargeDto;
import com.tobeto.rentacar.services.dtos.stripe.StripeTokenDto;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeManager {

    @Value("${api.stripe.secret-key}")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    public StripeTokenDto createCardToken(StripeTokenDto stripeTokenDto) {

        try {
            Map<String, Object> card = new HashMap<>();
            card.put("number", stripeTokenDto.getCardNumber());
            card.put("exp_month", Integer.parseInt(stripeTokenDto.getExpMonth()));
            card.put("exp_year", Integer.parseInt(stripeTokenDto.getExpYear()));
            card.put("cvc", stripeTokenDto.getCvc());
            Map<String, Object> params = new HashMap<>();
            params.put("card", card);
            Token token = Token.create(params);
            if (token != null && token.getId() != null) {
                stripeTokenDto.setSuccess(true);
                stripeTokenDto.setToken(token.getId());
            }
            return stripeTokenDto;
        } catch (StripeException e) {
            log.error("StripeService (createCardToken)", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public StripeChargeDto charge(StripeChargeDto chargeRequest) {


        try {
            chargeRequest.setSuccess(false);
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (chargeRequest.getAmount() * 100));
            chargeParams.put("currency", "USD");
            chargeParams.put("description", "Payment for id " + chargeRequest.getAdditionalInfo()
                    .getOrDefault("ID_TAG", ""));
            chargeParams.put("source", chargeRequest.getStripeToken());
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("id", chargeRequest.getChargeId());
            metaData.putAll(chargeRequest.getAdditionalInfo());
            chargeParams.put("metadata", metaData);
            Charge charge = Charge.create(chargeParams);
            chargeRequest.setMessage(charge.getOutcome().getSellerMessage());

            if (charge.getPaid()) {
                chargeRequest.setChargeId(charge.getId());
                chargeRequest.setSuccess(true);

            }
            return chargeRequest;
        } catch (StripeException e) {
            log.error("StripeService (charge)", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}

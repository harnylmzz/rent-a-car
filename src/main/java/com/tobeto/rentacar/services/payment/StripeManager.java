package com.tobeto.rentacar.services.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.tobeto.rentacar.repository.RentalRepository;
import com.tobeto.rentacar.services.dtos.stripe.StripeChargeDto;
import com.tobeto.rentacar.services.dtos.stripe.StripeTokenDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for handling Stripe-related operations.
 * Manages the creation of card tokens and charging payments using the Stripe API.
 * Requires initialization of the Stripe API key using the application properties.
 *
 * @author [Harun Yılmaz]
 */
@Service
@Slf4j
public class StripeManager {
    
    @Value("${api.stripe.key}")
    private String stripeApiKey;

    @Value("${api.stripe.secret-key}")
    private String stripeSecretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
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
            log.error("StripeManager (createCardToken)", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Charges the payment using the provided Stripe charge request information.
     *
     * @param chargeRequest The data transfer object containing charge information.
     * @return The updated StripeChargeDto with the charge ID, success status, and payment outcome message.
     */
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
            log.error("StripeManager (charge)", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}

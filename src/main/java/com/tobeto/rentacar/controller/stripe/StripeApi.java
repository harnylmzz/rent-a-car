package com.tobeto.rentacar.controller.stripe;

import com.tobeto.rentacar.services.concretes.stripe.StripeManager;
import com.tobeto.rentacar.services.dtos.stripe.StripeChargeDto;
import com.tobeto.rentacar.services.dtos.stripe.StripeTokenDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/stripe")
@AllArgsConstructor
public class StripeApi {

    private final StripeManager stripeManager;

    @PostMapping("/card/token")
    @ResponseBody
    public StripeTokenDto createCardToken(@RequestBody StripeTokenDto stripeTokenDto) {


        return stripeManager.createCardToken(stripeTokenDto);
    }

    @PostMapping("/charge")
    @ResponseBody
    public StripeChargeDto charge(@RequestBody StripeChargeDto stripeChargeDto) {

        return stripeManager.charge(stripeChargeDto);
    }

}

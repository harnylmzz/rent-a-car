package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.stripe.StripeManager;
import com.tobeto.rentacar.services.dtos.stripe.StripeChargeDto;
import com.tobeto.rentacar.services.dtos.stripe.StripeTokenDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling Stripe-related operations.
 * Exposes endpoints for creating card tokens and charging payments.
 * All endpoints are under the "/public/stripe" base path.
 * Requires an instance of {@link StripeManager} for handling Stripe operations.
 *
 * @author [Harun Yılmaz]
 */

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

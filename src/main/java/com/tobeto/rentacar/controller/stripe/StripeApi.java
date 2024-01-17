package com.tobeto.rentacar.controller.stripe;

import com.tobeto.rentacar.services.concretes.stripe.StripeManager;
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

    /**
     * The StripeManager instance for handling Stripe operations.
     */

    private final StripeManager stripeManager;

    /**
     * Endpoint for creating a card token.
     *
     * @param stripeTokenDto The data transfer object containing card information.
     * @return The created StripeTokenDto.
     */

    @PostMapping("/card/token")
    @ResponseBody
    public StripeTokenDto createCardToken(@RequestBody StripeTokenDto stripeTokenDto) {


        return stripeManager.createCardToken(stripeTokenDto);
    }

    /**
     * Endpoint for charging payments.
     *
     * @param stripeChargeDto The data transfer object containing charge information.
     * @return The created StripeChargeDto.
     */

    @PostMapping("/charge")
    @ResponseBody
    public StripeChargeDto charge(@RequestBody StripeChargeDto stripeChargeDto) {

        return stripeManager.charge(stripeChargeDto);
    }
}

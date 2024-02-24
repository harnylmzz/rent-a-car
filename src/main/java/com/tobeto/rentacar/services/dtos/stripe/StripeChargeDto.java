package com.tobeto.rentacar.services.dtos.stripe;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Transfer Object (DTO) representing information for a Stripe charge operation.
 * Contains details such as the Stripe token, username, amount, success status, message,
 * charge ID, and additional information.
 * Uses Lombok annotations for automatic generation of getters, setters, and other methods.
 *
 * @author [Harun Yılmaz]
 */

@Data
public class StripeChargeDto {
    private String stripeToken;
    private String username;
   // private Double amount;
    private Boolean success;
    private String message;
    private String chargeId;

    /**
     * Additional information associated with the charge.
     */

    private Map<String, Object> additionalInfo = new HashMap<>();
}

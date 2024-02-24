package com.tobeto.rentacar.services.dtos.stripe;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing information for a Stripe token.
 * Contains details such as card number, expiration month, expiration year,
 * CVC, token, username, and success status.
 * Uses Lombok annotations for automatic generation of getters, setters, and other methods.
 *
 * @author [Harun Yılmaz]
 */

@Data
public class StripeTokenDto {

    private String cardNumber;
    private String expMonth;
    private String expYear;
    private String cvc;
    private String token;
    private String username;
    private Double amount;
    private boolean success;
}

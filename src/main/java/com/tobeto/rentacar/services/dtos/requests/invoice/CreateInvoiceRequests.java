package com.tobeto.rentacar.services.dtos.requests.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequests {

    private String number;

    private int amount;

    private String vat;
}

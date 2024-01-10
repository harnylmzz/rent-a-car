package com.tobeto.rentacar.services.dtos.responses.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoiceResponses {

    private int id;

    private String number;

    private int amount;

    private String vat;
}

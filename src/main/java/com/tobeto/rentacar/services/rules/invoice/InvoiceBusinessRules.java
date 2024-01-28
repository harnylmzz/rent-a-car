package com.tobeto.rentacar.services.rules.invoice;

import com.tobeto.rentacar.repository.InvoiceRepository;
import com.tobeto.rentacar.services.messages.invoice.InvoiceMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {

    private final InvoiceRepository invoiceRepository;

    public void checkIfNumber(String number) {
        if (this.invoiceRepository.existsByNumber(number)) {
            throw new RuntimeException(InvoiceMessages.INVOICE_ALREADY_EXISTS);
        }
    }
}

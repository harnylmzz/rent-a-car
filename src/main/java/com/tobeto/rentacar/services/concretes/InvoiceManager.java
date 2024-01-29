package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Invoice;
import com.tobeto.rentacar.repository.InvoiceRepository;
import com.tobeto.rentacar.services.abstracts.InvoiceService;
import com.tobeto.rentacar.services.dtos.requests.invoice.CreateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.DeleteInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetAllInvoiceResponses;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetByIdInvoiceResponses;
import com.tobeto.rentacar.services.constans.invoice.InvoiceMessages;
import com.tobeto.rentacar.services.rules.invoice.InvoiceBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;
    private final InvoiceBusinessRules invoiceBusinessRules;

    @Override
    public DataResult<List<GetAllInvoiceResponses>> getAll() {

        List<Invoice> invoice = invoiceRepository.findAll();
        List<GetAllInvoiceResponses> getAllInvoiceResponses = invoice.stream()
                .map(invoice1 -> modelMapperService.forResponse()
                        .map(invoice1, GetAllInvoiceResponses.class)).toList();

        return new DataResult<>(getAllInvoiceResponses, true, InvoiceMessages.INVOICE_LISTED);
    }

    @Override
    public DataResult<GetByIdInvoiceResponses> getById(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new DataNotFoundException(InvoiceMessages.INVOICE_NOT_FOUND));

        GetByIdInvoiceResponses getByIdInvoiceResponses = modelMapperService.forResponse()
                .map(invoice, GetByIdInvoiceResponses.class);

        return new DataResult<>(getByIdInvoiceResponses, true, InvoiceMessages.INVOICE_LISTED);
    }

    @Override
    public Result add(CreateInvoiceRequests createInvoiceRequests) {

        invoiceBusinessRules.checkIfNumber(createInvoiceRequests.getNumber());

        Invoice invoice = modelMapperService.forRequest()
                .map(createInvoiceRequests, Invoice.class);

        invoiceRepository.save(invoice);

        return new SuccessResult(InvoiceMessages.INVOICE_ADDED);
    }

    @Override
    public Result update(UpdateInvoiceRequests updateInvoiceRequests) {

        Invoice invoice = modelMapperService.forRequest()
                .map(updateInvoiceRequests, Invoice.class);

        invoice.setId(updateInvoiceRequests.getId());
        invoice.setVat(updateInvoiceRequests.getVat());
        invoice.setNumber(updateInvoiceRequests.getNumber());
        invoice.setAmount(updateInvoiceRequests.getAmount());

        invoiceRepository.save(invoice);

        return new SuccessResult(InvoiceMessages.INVOICE_UPDATED);
    }

    @Override
    public Result delete(DeleteInvoiceRequests deleteInvoiceRequests) {

        Invoice invoice = modelMapperService.forRequest()
                .map(deleteInvoiceRequests, Invoice.class);

        invoiceRepository.delete(invoice);

        return new SuccessResult(InvoiceMessages.INVOICE_DELETED);
    }
}

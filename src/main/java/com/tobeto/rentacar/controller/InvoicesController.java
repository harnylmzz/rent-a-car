package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.InvoiceService;
import com.tobeto.rentacar.services.dtos.requests.invoice.CreateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.DeleteInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetAllInvoiceResponses;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetByIdInvoiceResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@AllArgsConstructor
public class InvoicesController {

    private InvoiceService invoiceService;

    @GetMapping("/getall")
    public DataResult<List<GetAllInvoiceResponses>> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdInvoiceResponses> getById(int id) {
        return invoiceService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateInvoiceRequests createInvoiceRequests) {
        return invoiceService.add(createInvoiceRequests);

    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateInvoiceRequests updateInvoiceRequests) {
        return invoiceService.update(updateInvoiceRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteInvoiceRequests deleteInvoiceRequests) {
        return invoiceService.delete(deleteInvoiceRequests);
    }
}

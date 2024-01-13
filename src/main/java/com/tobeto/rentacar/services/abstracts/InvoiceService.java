package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.invoice.CreateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.DeleteInvoiceRequests;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequests;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetAllInvoiceResponses;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetByIdInvoiceResponses;

import java.util.List;

public interface InvoiceService {

    DataResult<List<GetAllInvoiceResponses>> getAll();

    DataResult<GetByIdInvoiceResponses> getById(int id);

    Result add(CreateInvoiceRequests createInvoiceRequests);

    Result update(UpdateInvoiceRequests updateInvoiceRequests);

    Result delete(DeleteInvoiceRequests deleteInvoiceRequests);
}

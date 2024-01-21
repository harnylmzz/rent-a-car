package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rentals")
public class RentalsController {
    private final RentalService rentalService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllRentalResponses>> getAll() {

        return this.rentalService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdRentalResponses> getById(int id) {
        return rentalService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateRentalRequests createRentalRequests) {
        return this.rentalService.add(createRentalRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateRentalRequests updateRentalRequests) {
        return this.rentalService.update(updateRentalRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteRentalRequests deleteRentalRequests) {
        return this.rentalService.delete(deleteRentalRequests);
    }

    @GetMapping("/findbystartdate")
    public List<GetAllRentalResponses> findByStartDAte(@RequestParam LocalDate startDate){
        return this.rentalService.findByStartDate(startDate);
    }

    @GetMapping("/findbyenddate")
    public List<GetAllRentalResponses> findByEndDate(@RequestParam LocalDate endDate){
        return this.rentalService.findByEndDate(endDate);
    }

    @GetMapping("/findbyreturndate")
    public List<GetAllRentalResponses> findByReturnDate(@RequestParam LocalDate returnDate){
        return this.rentalService.findByReturnDate(returnDate);
    }

    @GetMapping("/findbystartkilometer")
    public List<GetAllRentalResponses> findByStartKilometer(@RequestParam int startKilometer){
        return this.rentalService.findByStartKilometer(startKilometer);

    }

    @GetMapping("/findbyendkilometer")
    public List<GetAllRentalResponses> findByEndKilometer(@RequestParam int endKilometer){
        return this.rentalService.findByEndKilometer(endKilometer);
    }

    @GetMapping("/findbytotalprice")
    public List<GetAllRentalResponses> findByTotalPrice(@RequestParam double totalPrice){
        return this.rentalService.findByTotalPrice(totalPrice);
    }

    @GetMapping("/findbydiscount")
    public List<GetAllRentalResponses> findByDiscount(@RequestParam double discount){
        return this.rentalService.findByDiscount(discount);
    }
}

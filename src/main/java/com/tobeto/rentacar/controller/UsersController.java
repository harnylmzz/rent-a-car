package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;
    @GetMapping("/getAll")
    public List<GetAllUserResponses> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdUserResponses getById(int id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateUserRequests createUserRequests) {
        this.userService.add(createUserRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequests updateUserRequest) {
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteUserRequests deleteUserRequests) {
        this.userService.delete(deleteUserRequests);
    }

}

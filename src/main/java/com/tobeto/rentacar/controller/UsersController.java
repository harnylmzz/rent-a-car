package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
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
    public DataResult<List<GetAllUserResponses>> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdUserResponses> getById(int id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateUserRequests createUserRequests) {
        return this.userService.add(createUserRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateUserRequests updateUserRequest) {
        return this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteUserRequests deleteUserRequests) {
        return this.userService.delete(deleteUserRequests);
    }

}

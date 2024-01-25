package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing user-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting users.
 * Utilizes the UserService for user-related operations.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/get xById")
    public DataResult<GetByIdUserResponses> getUserById(int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllUserResponses>> getAllUser() {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody CreateUserRequests createUserRequests) {
        return this.userService.add(createUserRequests);
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody UpdateUserRequests updateUserRequests) {
        return this.userService.update(updateUserRequests);
    }

    @DeleteMapping("/delete")
    public Result deleteUser(@RequestBody DeleteUserRequests deleteUserRequests) {
        return this.userService.delete(deleteUserRequests);
    }

}

package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.UserService;
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

    @GetMapping("/getUserById")
    public DataResult<GetByIdUserResponses> getUserById(int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getAllUser")
    public DataResult<List<GetAllUserResponses>> getAllUser() {
        return this.userService.getAll();
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody UpdateUserRequests updateUserRequests) {
        return this.userService.update(updateUserRequests);
    }

    @DeleteMapping("/deleteUser")
    public Result deleteUser(@RequestBody DeleteUserRequests deleteUserRequests) {
        return this.userService.delete(deleteUserRequests);
    }

}

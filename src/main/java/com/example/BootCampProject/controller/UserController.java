package com.example.BootCampProject.controller;


import com.example.BootCampProject.service.abstracts.UserService;
import com.example.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.example.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.example.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetListUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.UpdateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListUserResponse> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedUserResponse add(@RequestBody CreateUserRequest request){
        return userService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public UpdateUserResponse update(@RequestBody UpdateUserRequest request){
        return userService.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}

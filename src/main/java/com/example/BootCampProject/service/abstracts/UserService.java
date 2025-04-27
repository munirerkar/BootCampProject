package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.example.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.example.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetListUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.UpdateUserResponse;

import java.util.List;

public interface UserService {
    CreatedUserResponse add(CreateUserRequest request);
    List<GetListUserResponse> getAll();
    void delete(int id);
    UpdateUserResponse update(UpdateUserRequest request);
    GetUserResponse getById(int id);
}

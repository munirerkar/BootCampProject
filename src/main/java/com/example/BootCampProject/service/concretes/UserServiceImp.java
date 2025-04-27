package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.User;
import com.example.BootCampProject.repository.UserRepository;
import com.example.BootCampProject.service.abstracts.UserService;
import com.example.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.example.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.example.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetListUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.example.BootCampProject.service.dtos.responses.User.UpdateUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreatedUserResponse add(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User createdUser = userRepository.save(user);

        CreatedUserResponse response = new CreatedUserResponse();
        response.setId(createdUser.getId());
        response.setUsername(createdUser.getUsername());
        response.setFirstName(createdUser.getFirstName());
        response.setLastName(createdUser.getLastName());
        response.setDateOfBirth(createdUser.getDateOfBirth());
        response.setNationalIdentity(createdUser.getNationalIdentity());
        response.setEmail(createdUser.getEmail());
        response.setPassword(createdUser.getPassword());
        return response;
    }

    @Override
    public List<GetListUserResponse> getAll() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(()->new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User updateUser = userRepository.save(user);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setId(updateUser.getId());
        response.setUsername(updateUser.getUsername());
        response.setFirstName(updateUser.getFirstName());
        response.setLastName(updateUser.getLastName());
        response.setDateOfBirth(updateUser.getDateOfBirth());
        response.setNationalIdentity(updateUser.getNationalIdentity());
        response.setEmail(updateUser.getEmail());
        response.setPassword(updateUser.getPassword());
        return response;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User id not found"));
        return mapToUserResponse(user);
    }
    private GetListUserResponse mapToResponse(User user){
        GetListUserResponse response = new GetListUserResponse(user.getId(),user.getUsername(),user.getFirstName(),user.getLastName(),user.getDateOfBirth(),user.getNationalIdentity(),user.getEmail(),user.getPassword());
        return response;
    }
    private GetUserResponse mapToUserResponse(User user){
        GetUserResponse response = new GetUserResponse(user.getId(),user.getUsername(),user.getFirstName(),user.getLastName(),user.getDateOfBirth(),user.getNationalIdentity(),user.getEmail(),user.getPassword());
        return response;
    }
}

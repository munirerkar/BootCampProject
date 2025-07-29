package com.example.BootCampProject.controller;

import com.example.BootCampProject.entity.User;
import com.example.BootCampProject.repository.UserRepository;
import com.example.BootCampProject.service.abstracts.UserService;
import com.example.BootCampProject.service.dtos.requests.Auth.LoginRequest;
import com.example.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.example.BootCampProject.service.dtos.responses.Auth.LoginResponse;
import com.example.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;

    public AuthController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<CreatedUserResponse> register(@RequestBody CreateUserRequest request) {
        // Aynı TCKN veya e-posta ile kayıt kontrolü yapılabilir
        boolean exists = userRepository.existsByEmail(request.getEmail());
        if (exists) {
            return ResponseEntity.badRequest().build();
        }

        CreatedUserResponse response = userService.add(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (user == null) {
            return ResponseEntity.status(401).body(new LoginResponse("Hatalı e-posta veya şifre."));
        }

        return ResponseEntity.ok(new LoginResponse("Giriş başarılı. Hoş geldiniz, " + user.getFirstName() + "!"));
    }
}

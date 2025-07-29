package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}

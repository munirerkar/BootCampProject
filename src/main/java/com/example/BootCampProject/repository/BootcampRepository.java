package com.example.BootCampProject.repository;


import com.example.BootCampProject.entity.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
    List<Bootcamp> findByBootcampState(Bootcamp.BootcampState bootcampState);
    List<Bootcamp> getByName(String name);
    Bootcamp getByNameIgnoreCase(String name);
    Boolean existsByInstructorId(int instructorId);
    boolean existsByIdAndDeletedAtIsNull(int bootcampId);
}

package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
    Applicant getByIdentityIgnoreCase(String nationalIdentity);
}

package com.example.BootCampProject.repository;


import com.example.BootCampProject.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    List<Application> findByApplicantId(int applicantId);
}

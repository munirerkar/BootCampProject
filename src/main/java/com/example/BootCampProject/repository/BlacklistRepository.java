package com.example.BootCampProject.repository;


import com.example.BootCampProject.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist,Integer> {
    List<Blacklist> findByApplicantId(int applicantId);
}

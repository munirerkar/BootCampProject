package com.example.BootCampProject.service.rules;

import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.repository.ApplicantRepository;
import com.example.BootCampProject.repository.BlacklistRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantBusinessRules {
    private final ApplicantRepository applicantRepository;
    private final BlacklistRepository blacklistRepository;

    public ApplicantBusinessRules(ApplicantRepository applicantRepository, BlacklistRepository blacklistRepository) {
        this.applicantRepository = applicantRepository;
        this.blacklistRepository = blacklistRepository;
    }
    public void checkIfIdentityExists(String nationalIdentity){
        Applicant applicant = applicantRepository.getByIdentityIgnoreCase(nationalIdentity);
        if(applicant!=null)
            throw new BusinessException("Aynı TC Kimlik No ile birden fazla başvuru yapılamaz.");

    }
    public void checkIfBlacklisted(int applicantId) {
        boolean isBlacklisted = blacklistRepository.existsByApplicant_Id(applicantId);
        if (isBlacklisted)
            throw new BusinessException("Kara listeye alınan bir başvuru sahibi yeni başvuru yapamaz.");
    }
    public void checkIfApplicantExists(int applicantId) {
        boolean exists = applicantRepository.existsById(applicantId);
        if (!exists) {
            throw new BusinessException("Sistemde kayıtlı olmayan bir başvuru sahibi ile işlem yapılamaz.");
        }
    }
}

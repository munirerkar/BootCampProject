package com.example.BootCampProject.service.rules;

import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.repository.BlacklistRepository;
import org.springframework.stereotype.Service;

@Service
public class BlacklistBusinessRules {
    private final BlacklistRepository blacklistRepository;

    public BlacklistBusinessRules(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    public void checkIfApplicantAlreadyBlacklisted(int applicantId) {
        boolean exists = blacklistRepository.existsByApplicant_Id(applicantId);
        if (exists) {
            throw new BusinessException("Bu adaya ait aktif bir kara liste kaydı zaten mevcut.");
        }
    }
    public void checkIfReasonIsNotBlank(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            throw new BusinessException("Sebep (reason) boş bırakılamaz.");
        }
    }
}

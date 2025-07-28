package com.example.BootCampProject.service.rules;

import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.repository.ApplicationRepository;
import com.example.BootCampProject.repository.BlacklistRepository;
import com.example.BootCampProject.repository.BootcampRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationBusinessRules {
    private final ApplicationRepository applicationRepository;
    private final BootcampRepository bootcampRepository;
    private final BlacklistRepository blacklistRepository;

    public ApplicationBusinessRules(ApplicationRepository applicationRepository, BootcampRepository bootcampRepository, BlacklistRepository blacklistRepository) {
        this.applicationRepository = applicationRepository;
        this.bootcampRepository = bootcampRepository;
        this.blacklistRepository = blacklistRepository;
    }
    public void checkIfAlreadyApplied(int applicantId, int bootcampId) {
        boolean exists = applicationRepository.existsByApplicantIdAndBootcampId(applicantId, bootcampId);
        if (exists) {
            throw new BusinessException("Aynı kişi aynı Bootcamp'e birden fazla başvuru yapamaz.");
        }
    }
    public void checkIfBootcampIsActive(int bootcampId) {
        boolean isActive = bootcampRepository.existsByIdAndDeletedAtIsNull(bootcampId);
        if (!isActive) {
            throw new BusinessException("Başvuru yapılan bootcamp aktif olmalıdır.");
        }
    }
    public void checkIfBlacklisted(int applicantId) {
        boolean isBlacklisted = blacklistRepository.existsByApplicant_Id(applicantId);
        if (isBlacklisted)
            throw new BusinessException("Kara listeye alınmış bir aday başvuru yapamaz.");
    }
    public void checkValidApplicationStatusTransition(
            Application.ApplicationState currentState,
            Application.ApplicationState newState
    ) {
        switch (currentState) {
            case PENDING -> {
                if (newState != Application.ApplicationState.IN_REVIEW &&
                        newState != Application.ApplicationState.APPROVED &&
                        newState != Application.ApplicationState.REJECTED &&
                        newState != Application.ApplicationState.CANCELLED) {
                    throw new BusinessException("Geçersiz başvuru durumu geçişi: PENDING → " + newState);
                }
            }
            case IN_REVIEW -> {
                if (newState != Application.ApplicationState.APPROVED &&
                        newState != Application.ApplicationState.REJECTED) {
                    throw new BusinessException("Geçersiz başvuru durumu geçişi: IN_REVIEW → " + newState);
                }
            }
            case APPROVED, REJECTED, CANCELLED -> {
                if (newState != currentState) {
                    throw new BusinessException("Bu başvuru durumu değiştirilemez: " + currentState);
                }
            }
        }
    }
}

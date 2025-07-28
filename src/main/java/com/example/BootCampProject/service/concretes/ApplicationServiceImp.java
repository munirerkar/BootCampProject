package com.example.BootCampProject.service.concretes;


import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.repository.ApplicationRepository;
import com.example.BootCampProject.service.abstracts.ApplicationService;
import com.example.BootCampProject.service.dtos.requests.Application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Application.UpdateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.Application.CreatedApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.UpdateApplicationResponse;
import com.example.BootCampProject.service.mappers.ApplicationMapper;
import com.example.BootCampProject.service.rules.ApplicationBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImp implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationBusinessRules rules;

    public ApplicationServiceImp(ApplicationRepository applicationRepository, ApplicationBusinessRules rules) {
        this.applicationRepository = applicationRepository;
        this.rules = rules;
    }


    @Override
    public CreatedApplicationResponse add(CreateApplicationRequest request) {
        rules.checkIfAlreadyApplied(request.getApplicantId(), request.getBootcampId());
        rules.checkIfBootcampIsActive(request.getBootcampId());
        rules.checkIfBlacklisted(request.getApplicantId());
        Application application = ApplicationMapper.INSTANCE.createApplicationRequestToApplication(request);
        Application createdApplication = applicationRepository.save(application);
        return ApplicationMapper.INSTANCE.createApplicationResponseFromApplication(createdApplication);
    }

    @Override
    public List<GetListApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<GetListApplicationResponse> response = applications.stream().map(ApplicationMapper.INSTANCE::getAllApplicationResponsesFromApplications).collect(Collectors.toList());
        return response;
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public UpdateApplicationResponse update(UpdateApplicationRequest request) {
        Application existingApp = applicationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + request.getId()));
        Application.ApplicationState currentState = existingApp.getApplicationState();
        Application.ApplicationState newState = request.getApplicationState();

        rules.checkValidApplicationStatusTransition(currentState, newState);
        Application application = ApplicationMapper.INSTANCE.updateApplicationRequestToApplication(request);
        applicationRepository.findById(application.getId()).orElseThrow(() -> new RuntimeException("Application not found with id: " + application.getId()));
        Application updated = applicationRepository.save(application);
        return ApplicationMapper.INSTANCE.updateApplicationResponseFromApplication(updated);
    }

    @Override
    public GetApplicationResponse getById(int id) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found id: " + id));
        return ApplicationMapper.INSTANCE.getApplicationResponseFromApplication(application);
    }

    @Override
    public List<GetListApplicationResponse> findByApplicantId(int applicantId) {
        List<Application> applications = applicationRepository.findByApplicantId(applicantId);
        List<GetListApplicationResponse> responses = applications.stream().map(ApplicationMapper.INSTANCE::getAllApplicationResponsesFromApplications).collect(Collectors.toList());
        return responses;
    }
}

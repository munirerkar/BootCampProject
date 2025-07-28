package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.repository.ApplicantRepository;
import com.example.BootCampProject.service.abstracts.ApplicantService;
import com.example.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.example.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.example.BootCampProject.service.dtos.responses.Applicant.CreateApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetListApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;
import com.example.BootCampProject.service.mappers.ApplicantMapper;
import com.example.BootCampProject.service.rules.ApplicantBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImp implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ApplicantBusinessRules rules;

    public ApplicantServiceImp(ApplicantRepository applicantRepository, ApplicantBusinessRules rules) {
        this.applicantRepository = applicantRepository;
        this.rules = rules;
    }


    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {
        rules.checkIfBlacklisted(request.getApplicationId());
        Applicant applicant = ApplicantMapper.INSTANCE.createApplicantRequestToApplicant(request);
        rules.checkIfIdentityExists(applicant.getUser().getNationalIdentity());
        Applicant createdApplicant = applicantRepository.save(applicant);
        return ApplicantMapper.INSTANCE.createApplicantResponseFromApplicant(createdApplicant);
    }

    @Override
    public List<GetListApplicantResponse> getAll() {
        List<Applicant> applicant= applicantRepository.findAll();
        List<GetListApplicantResponse> response = applicant.stream().map(ApplicantMapper.INSTANCE::getAllApplicantResponseFromApplicant).collect(Collectors.toList());
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfApplicantExists(id);
        applicantRepository.deleteById(id);
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest request) {
        rules.checkIfApplicantExists(request.getApplicationId());
        Applicant applicant = ApplicantMapper.INSTANCE.updateApplicantRequestToApplicant(request);
        applicantRepository.findById(applicant.getId()).orElseThrow(() -> new RuntimeException("Applicant not found with id: " + applicant.getId()));
        Applicant updated = applicantRepository.save(applicant);
        return ApplicantMapper.INSTANCE.updateApplicantResponseFromApplicant(updated);
    }

    @Override
    public GetApplicantResponse getById(int id) {
        rules.checkIfApplicantExists(id);
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found id: " + id));
        return ApplicantMapper.INSTANCE.getApplicantResponseFromApplicant(applicant);
    }
}

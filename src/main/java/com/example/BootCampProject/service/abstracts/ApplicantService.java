package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.example.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.example.BootCampProject.service.dtos.responses.Applicant.CreateApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetListApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;


import java.util.List;

public interface ApplicantService {
    CreateApplicantResponse add(CreateApplicantRequest request);
    List<GetListApplicantResponse> getAll();
    void delete(int id);
    UpdateApplicantResponse update(UpdateApplicantRequest request);
    GetApplicantResponse getById(int id);
}

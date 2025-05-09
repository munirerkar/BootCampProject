package com.example.BootCampProject.service.abstracts;


import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.service.dtos.requests.Application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Application.UpdateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.Application.CreatedApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.UpdateApplicationResponse;

import java.util.List;

public interface ApplicationService {
    CreatedApplicationResponse add(CreateApplicationRequest request);
    List<GetListApplicationResponse> getAll();
    void delete(int id);
    UpdateApplicationResponse update(UpdateApplicationRequest request);
    GetApplicationResponse getById(int id);
    List<GetListApplicationResponse> findByApplicantId(int applicantId);
}

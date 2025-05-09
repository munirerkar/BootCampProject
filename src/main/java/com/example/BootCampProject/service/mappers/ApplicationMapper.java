package com.example.BootCampProject.service.mappers;




import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.service.dtos.requests.Application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Application.UpdateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.Application.CreatedApplicationResponse;

import com.example.BootCampProject.service.dtos.responses.Application.GetApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.UpdateApplicationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    @Mapping(source = "applicantId",target="applicant.id")
    @Mapping(source = "bootcampId",target="bootcamp.id")
    Application createApplicationRequestToApplication(CreateApplicationRequest createApplicationRequest);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    CreatedApplicationResponse createApplicationResponseFromApplication(Application application);

    @Mapping(source = "applicantId",target="applicant.id")
    @Mapping(source = "bootcampId",target="bootcamp.id")
    Application updateApplicationRequestToApplication(UpdateApplicationRequest updateApplicationRequest);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    UpdateApplicationResponse updateApplicationResponseFromApplication(Application application);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    GetApplicationResponse getApplicationResponseFromApplication(Application application);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    GetListApplicationResponse getAllApplicationResponsesFromApplications(Application applications);



}

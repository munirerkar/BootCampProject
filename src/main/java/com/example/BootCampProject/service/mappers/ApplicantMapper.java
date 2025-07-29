package com.example.BootCampProject.service.mappers;


import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.example.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.example.BootCampProject.service.dtos.responses.Applicant.CreateApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.GetListApplicantResponse;
import com.example.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicantMapper {
    ApplicantMapper INSTANCE = Mappers.getMapper(ApplicantMapper.class);

    @Mapping(source = "userId", target = "user.id")
    Applicant createApplicantRequestToApplicant(CreateApplicantRequest createApplicantRequest);

    @Mapping(source = "user.id", target = "userId")
    CreateApplicantResponse createApplicantResponseFromApplicant(Applicant applicant);

    @Mapping(source = "userId",target="user.id")
    Applicant updateApplicantRequestToApplicant(UpdateApplicantRequest updateApplicantRequest);

    @Mapping(source = "user.id", target = "userId")
    UpdateApplicantResponse updateApplicantResponseFromApplicant(Applicant applicant);

    @Mapping(source = "user.id", target = "userId")
    GetApplicantResponse getApplicantResponseFromApplicant(Applicant applicant);

    @Mapping(source = "user.id", target = "userId")
    GetListApplicantResponse getAllApplicantResponseFromApplicant(Applicant applicant);

}

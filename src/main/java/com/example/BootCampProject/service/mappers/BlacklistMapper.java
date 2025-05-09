package com.example.BootCampProject.service.mappers;

import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.entity.Blacklist;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.service.dtos.requests.Application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Application.UpdateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Blacklist.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.requests.Blacklist.UpdateBlacklistRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.UpdateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.Application.CreatedApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.UpdateApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.CreatedBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetListBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.UpdateBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.CreatedBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetListBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.UpdateBootcampResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BlacklistMapper {
    BlacklistMapper INSTANCE = Mappers.getMapper(BlacklistMapper.class);

    @Mapping(source = "applicantId",target="applicant.id")
    Blacklist createBlacklistRequestToBlacklist(CreateBlacklistRequest createBlacklistRequest);

    @Mapping(source = "applicant.id", target = "applicantId")
    CreatedBlacklistResponse createBlacklistResponseFromBlacklist(Blacklist blacklist);

    @Mapping(source = "applicantId",target="applicant.id")
    Blacklist updateBlacklistRequestToBlacklist(UpdateBlacklistRequest updateBlacklistRequest);

    @Mapping(source = "applicant.id", target = "applicantId")
    UpdateBlacklistResponse updateBlacklistResponseFromBlacklist(Blacklist Blacklist);

    @Mapping(source = "applicant.id", target = "applicantId")
    GetBlacklistResponse getBlacklistResponseFromBlacklist(Blacklist Blacklist);
    @Mapping(source = "applicant.id", target = "applicantId")
    GetListBlacklistResponse getAllBlacklistResponsesFromBlacklist(Blacklist blacklist);
}

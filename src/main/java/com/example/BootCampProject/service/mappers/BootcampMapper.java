package com.example.BootCampProject.service.mappers;

import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.UpdateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BootcampMapper {
    BootcampMapper INSTANCE = Mappers.getMapper(BootcampMapper.class);

    DeletedBootcampResponse deletedBrandResponseFromBrand(Bootcamp bootcamp);

    @Mapping(source = "instructorId",target="instructor.id")
    Bootcamp bootcampFromCreateBootcampRequest(CreateBootcampRequest createBootcampRequest);

    @Mapping(source = "instructorId",target="instructor.id")
    Bootcamp bootcampFromUpdateBootcampRequest(UpdateBootcampRequest updateBootcampRequest);

    @Mapping(target="instructorId",source = "instructor.id")
    CreatedBootcampResponse createdBootcampResponseFromBootcamp(Bootcamp bootcamp);

    @Mapping(target="instructorId",source = "instructor.id")
    UpdateBootcampResponse updateBootcampResponseFromBootcamp(Bootcamp bootcamp);

    @Mapping(target = "instructorId", source = "instructor.id")
    GetBootcampResponse getBootcampResponseFromBootcamp(Bootcamp bootcamp);
    @Mapping(target = "instructorId", source = "instructor.id")
    GetListBootcampResponse getListBootcampResponsesFromBootcamps(Bootcamp bootcamps);
}

package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.ApplicationService;
import com.example.BootCampProject.service.dtos.requests.Application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.requests.Application.UpdateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.Application.CreatedApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Application.UpdateApplicationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListApplicationResponse> getApplications(){
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetApplicationResponse getById(@PathVariable int id){
        return applicationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedApplicationResponse add(@RequestBody CreateApplicationRequest request){
        return applicationService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public UpdateApplicationResponse update(@RequestBody UpdateApplicationRequest request){
        return applicationService.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        applicationService.delete(id);
    }

    @GetMapping("/applicant/{applicantId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListApplicationResponse> findByApplicantId(int applicantId) {
        return applicationService.findByApplicantId(applicantId);
    }
}

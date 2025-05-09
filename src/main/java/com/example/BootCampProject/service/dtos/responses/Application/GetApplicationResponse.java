package com.example.BootCampProject.service.dtos.responses.Application;

import com.example.BootCampProject.entity.Application;


public class GetApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private Application.ApplicationState applicationState;

    public GetApplicationResponse() {

    }

    public GetApplicationResponse(int id, int applicantId, int bootcampId, Application.ApplicationState applicationState) {
        this.id = id;
        this.applicantId = applicantId;
        this.bootcampId = bootcampId;
        this.applicationState = applicationState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getBootcampId() {
        return bootcampId;
    }

    public void setBootcampId(int bootcampId) {
        this.bootcampId = bootcampId;
    }

    public Application.ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(Application.ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}

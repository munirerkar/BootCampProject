package com.example.BootCampProject.service.dtos.requests.Application;


import com.example.BootCampProject.entity.Application;



public class CreateApplicationRequest {
    private int applicantId;
    private int bootcampId;
    private Application.ApplicationState applicationState;

    public CreateApplicationRequest(){
    }

    public CreateApplicationRequest(int applicantId, int bootcampId, Application.ApplicationState applicationState) {
        this.applicantId = applicantId;
        this.bootcampId = bootcampId;
        this.applicationState = applicationState;
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

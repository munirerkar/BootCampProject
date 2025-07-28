package com.example.BootCampProject.service.dtos.requests.Applicant;



public class CreateApplicantRequest {
    private String about;
    private int userId;
    private int applicationId;
    private int blacklistId;

    public CreateApplicantRequest(){
    }

    public CreateApplicantRequest(String about, int userId, int applicationId, int blacklistId) {
        this.about = about;
        this.userId = userId;
        this.applicationId = applicationId;
        this.blacklistId = blacklistId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getBlacklistId() {
        return blacklistId;
    }

    public void setBlacklistId(int blacklistId) {
        this.blacklistId = blacklistId;
    }
}

package com.example.BootCampProject.service.dtos.requests.Applicant;


public class UpdateApplicantRequest {
    private int id;
    private String about;
    private int userId;
    private int applicationId;
    private int blacklistId;

    public UpdateApplicantRequest() {

    }

    public UpdateApplicantRequest(int id, String about, int userId, int applicationId, int blacklistId) {
        this.id = id;
        this.about = about;
        this.userId = userId;
        this.applicationId = applicationId;
        this.blacklistId = blacklistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

package com.example.BootCampProject.service.dtos.requests.Blacklist;


import java.sql.Date;

public class CreateBlacklistRequest {
    private String reason;
    private int applicantId;

    public CreateBlacklistRequest() {

    }

    public CreateBlacklistRequest(String reason, Date date, int applicantId) {
        this.reason = reason;
        this.applicantId = applicantId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

}

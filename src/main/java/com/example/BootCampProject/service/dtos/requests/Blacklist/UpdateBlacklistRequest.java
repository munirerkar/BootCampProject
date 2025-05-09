package com.example.BootCampProject.service.dtos.requests.Blacklist;

import java.sql.Date;
import java.time.LocalDate;

public class UpdateBlacklistRequest {
    private int id;
    private String reason;
    private int applicantId;

    public UpdateBlacklistRequest() {

    }

    public UpdateBlacklistRequest(int id, String reason, int applicantId) {
        this.id = id;
        this.reason = reason;
        this.applicantId = applicantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

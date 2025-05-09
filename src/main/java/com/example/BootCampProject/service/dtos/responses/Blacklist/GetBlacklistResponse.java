package com.example.BootCampProject.service.dtos.responses.Blacklist;

import java.sql.Date;
import java.time.LocalDateTime;

public class GetBlacklistResponse {
    private int id;
    private String reason;
    private LocalDateTime date;
    private int applicantId;

    public GetBlacklistResponse() {

    }

    public GetBlacklistResponse(int id, String reason, LocalDateTime date, int applicantId) {
        this.id = id;
        this.reason = reason;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }
}

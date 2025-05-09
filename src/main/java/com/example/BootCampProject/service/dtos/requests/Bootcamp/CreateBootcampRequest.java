package com.example.BootCampProject.service.dtos.requests.Bootcamp;

import com.example.BootCampProject.entity.Bootcamp;

import java.sql.Date;

public class CreateBootcampRequest {
    private String name;
    private int instructorId;
    private Date startDate;
    private Date endDate;
    private Bootcamp.BootcampState bootcampState;
    public CreateBootcampRequest() {
    }

    public CreateBootcampRequest(String name, int instructorId, Date startDate, Date endDate, Bootcamp.BootcampState bootcampState) {
        this.name = name;
        this.instructorId = instructorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Bootcamp.BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(Bootcamp.BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }
}

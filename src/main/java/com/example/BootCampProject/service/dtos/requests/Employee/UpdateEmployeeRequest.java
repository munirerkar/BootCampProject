package com.example.BootCampProject.service.dtos.requests.Employee;

import java.sql.Date;

public class UpdateEmployeeRequest {
    private int id;
    private String position;
    private int userId;

    public UpdateEmployeeRequest() {
    }

    public UpdateEmployeeRequest(int id, String position, int userId) {
        this.id = id;
        this.position = position;
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

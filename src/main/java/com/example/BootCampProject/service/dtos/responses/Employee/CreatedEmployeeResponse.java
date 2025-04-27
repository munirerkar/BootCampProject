package com.example.BootCampProject.service.dtos.responses.Employee;

public class CreatedEmployeeResponse {
    private int id;
    private String position;
    private int userId;

    public CreatedEmployeeResponse() {
    }

    public CreatedEmployeeResponse(int id, String position, int userId) {
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

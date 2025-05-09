package com.example.BootCampProject.service.dtos.requests.Employee;



public class CreateEmployeeRequest {
    private String position;
    private int userId;

    public CreateEmployeeRequest() {
    }

    public CreateEmployeeRequest(String position, int userId) {
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
}

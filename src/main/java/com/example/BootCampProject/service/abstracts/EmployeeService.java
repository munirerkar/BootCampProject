package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.example.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.example.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetListEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    CreatedEmployeeResponse add(CreateEmployeeRequest request);
    List<GetListEmployeeResponse> getAll();
    void delete(int id);
    UpdateEmployeeResponse update(UpdateEmployeeRequest request);
    GetEmployeeResponse getById(int id);
}

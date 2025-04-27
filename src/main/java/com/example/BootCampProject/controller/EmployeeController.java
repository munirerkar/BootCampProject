package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.EmployeeService;
import com.example.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.example.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.example.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetListEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListEmployeeResponse> getEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetEmployeeResponse getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedEmployeeResponse add(@RequestBody CreateEmployeeRequest request){
        return employeeService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public UpdateEmployeeResponse update(@RequestBody UpdateEmployeeRequest request){
        return employeeService.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }
}

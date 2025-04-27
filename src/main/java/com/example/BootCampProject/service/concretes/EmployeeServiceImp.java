package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.Employee;
import com.example.BootCampProject.entity.User;
import com.example.BootCampProject.repository.EmployeeRepository;
import com.example.BootCampProject.repository.UserRepository;
import com.example.BootCampProject.service.abstracts.EmployeeService;
import com.example.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.example.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.example.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.GetListEmployeeResponse;
import com.example.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreatedEmployeeResponse add(CreateEmployeeRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Employee employee = new Employee();
        employee.setPosition(request.getPosition());
        employee.setUser(user);
        Employee createdEmployee = employeeRepository.save(employee);

        CreatedEmployeeResponse response = new CreatedEmployeeResponse();
        response.setId(createdEmployee.getId());
        response.setPosition(createdEmployee.getPosition());
        response.setUserId(createdEmployee.getUser().getId());
        return response;
    }

    @Override
    public List<GetListEmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Employee employee = employeeRepository.findById(request.getId()).orElseThrow(()->new RuntimeException("Employee not found"));
        employee.setPosition(request.getPosition());
        employee.setUser(user);
        Employee updateEmployee = employeeRepository.save(employee);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setId(updateEmployee.getId());
        response.setPosition(updateEmployee.getPosition());
        response.setUserId(updateEmployee.getUser().getId());
        return response;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("User id not found"));
        return mapToUserResponse(employee);
    }
    private GetListEmployeeResponse mapToResponse(Employee employee){
        GetListEmployeeResponse response = new GetListEmployeeResponse(employee.getId(),employee.getPosition(),employee.getUser().getId());
        return response;
    }
    private GetEmployeeResponse mapToUserResponse(Employee employee){
        GetEmployeeResponse response = new GetEmployeeResponse(employee.getId(),employee.getPosition(),employee.getUser().getId());
        return response;
    }
}

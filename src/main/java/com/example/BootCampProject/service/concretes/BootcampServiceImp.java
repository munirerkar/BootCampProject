package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.entity.Employee;
import com.example.BootCampProject.repository.BootcampRepository;
import com.example.BootCampProject.service.abstracts.BootcampService;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.UpdateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.*;
import com.example.BootCampProject.service.dtos.responses.Employee.GetListEmployeeResponse;
import com.example.BootCampProject.service.mappers.BootcampMapper;
import com.example.BootCampProject.service.rules.BootcampBusinessRules;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootcampServiceImp implements BootcampService {
    private final BootcampRepository bootcampRepository;
    private final BootcampBusinessRules rules;

    public BootcampServiceImp(BootcampRepository bootcampRepository, BootcampBusinessRules rules) {
        this.bootcampRepository = bootcampRepository;
        this.rules = rules;
    }

    @Override
    public CreatedBootcampResponse add(CreateBootcampRequest request) {

        rules.checkIfNameExists(request.getName());
        rules.checkStartDateBeforeEndDate(request.getStartDate(),request.getEndDate());
        rules.checkIfInstructorExists(request.getInstructorId());
        Bootcamp bootcamp = BootcampMapper.INSTANCE.bootcampFromCreateBootcampRequest(request);
        rules.checkIfBootcampOpenForApplication(bootcamp.getId());
        Bootcamp createdBootcamp = bootcampRepository.save(bootcamp);
        CreatedBootcampResponse response = BootcampMapper.INSTANCE.createdBootcampResponseFromBootcamp(createdBootcamp);
        return response;
    }

    @Override
    public List<GetListBootcampResponse> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        return bootcamps.stream().map(BootcampMapper.INSTANCE::getListBootcampResponsesFromBootcamps).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        bootcampRepository.deleteById(id);
    }

    @Override
    public UpdateBootcampResponse update(UpdateBootcampRequest request) {
        rules.checkStartDateBeforeEndDate(request.getStartDate(),request.getEndDate());
        Bootcamp bootcamp = BootcampMapper.INSTANCE.bootcampFromUpdateBootcampRequest(request);
        bootcampRepository.findById(bootcamp.getId()).orElseThrow(() -> new RuntimeException("Bootcamp not found with id: " + bootcamp.getId()));
        Bootcamp updated = bootcampRepository.save(bootcamp);
        UpdateBootcampResponse response = BootcampMapper.INSTANCE.updateBootcampResponseFromBootcamp(updated);
        return response;
    }

    @Override
    public GetBootcampResponse getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bootcamp not found with id: " + id));
        GetBootcampResponse response = BootcampMapper.INSTANCE.getBootcampResponseFromBootcamp(bootcamp);
        return response;
    }

    @Override
    public List<GetListBootcampResponse> findByBootcampState(Bootcamp.BootcampState bootcampState) {
        List<Bootcamp> bootcamps = bootcampRepository.findByBootcampState(bootcampState);
        List<GetListBootcampResponse> responses = bootcamps.stream().map(BootcampMapper.INSTANCE::getListBootcampResponsesFromBootcamps).collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetListBootcampResponse> getByName(String name) {
        List<Bootcamp> bootcamps = bootcampRepository.getByName(name);
        List<GetListBootcampResponse> responses = bootcamps.stream().map(BootcampMapper.INSTANCE::getListBootcampResponsesFromBootcamps).collect(Collectors.toList());
        return responses;
    }

    @Override
    public DeletedBootcampResponse softDelete(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow(()->new RuntimeException("Bootcamp not found"));
        bootcamp.setDeletedAt(LocalDateTime.now());
        Bootcamp deletedBootcamp = bootcampRepository.save(bootcamp);
        DeletedBootcampResponse response = BootcampMapper.INSTANCE.deletedBrandResponseFromBrand(deletedBootcamp);
        return response;
    }

}

package com.example.BootCampProject.service.abstracts;


import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.UpdateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.CreatedBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetListBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.UpdateBootcampResponse;


import java.util.List;

public interface BootcampService {
    CreatedBootcampResponse add(CreateBootcampRequest request);
    List<GetListBootcampResponse> getAll();
    void delete(int id);
    UpdateBootcampResponse update(UpdateBootcampRequest request);
    GetBootcampResponse getById(int id);
    List<GetListBootcampResponse> findByBootcampState(Bootcamp.BootcampState bootcampState);
}

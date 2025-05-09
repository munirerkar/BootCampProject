package com.example.BootCampProject.controller;

import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.service.abstracts.BootcampService;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.requests.Bootcamp.UpdateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.CreatedBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.GetListBootcampResponse;
import com.example.BootCampProject.service.dtos.responses.Bootcamp.UpdateBootcampResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamp")
public class BootcampController {
    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListBootcampResponse> getBootcamps(){
        return bootcampService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetBootcampResponse getById(@PathVariable int id){
        return bootcampService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedBootcampResponse add(@RequestBody CreateBootcampRequest request){
        return bootcampService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public UpdateBootcampResponse update(@RequestBody UpdateBootcampRequest request){
        return bootcampService.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        bootcampService.delete(id);
    }

    @GetMapping("/bootcampState/{bootcampState}")
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListBootcampResponse> getBootcampStates(Bootcamp.BootcampState bootcampState){
        return bootcampService.findByBootcampState(bootcampState);
    }
}

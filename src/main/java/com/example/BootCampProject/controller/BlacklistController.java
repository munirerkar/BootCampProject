package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.BlacklistService;
import com.example.BootCampProject.service.dtos.requests.Blacklist.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.requests.Blacklist.UpdateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.CreatedBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetListBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.UpdateBlacklistResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blacklist")
public class BlacklistController {
    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListBlacklistResponse> getBlacklists(){
        return blacklistService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetBlacklistResponse getById(@PathVariable int id){
        return blacklistService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedBlacklistResponse add(@RequestBody CreateBlacklistRequest request){
        return blacklistService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public UpdateBlacklistResponse update(@RequestBody UpdateBlacklistRequest request){
        return blacklistService.update(request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        blacklistService.delete(id);
    }
    @GetMapping("/applicant/{applicantId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBlacklistResponse> findByApplicantId(int applicantId) {
        return blacklistService.findByApplicantId(applicantId);
    }
}

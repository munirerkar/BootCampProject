package com.example.BootCampProject.service.abstracts;



import com.example.BootCampProject.service.dtos.requests.Blacklist.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.requests.Blacklist.UpdateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.Blacklist.CreatedBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetListBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.UpdateBlacklistResponse;

import java.util.List;

public interface BlacklistService {
    CreatedBlacklistResponse add(CreateBlacklistRequest request);
    List<GetListBlacklistResponse> getAll();
    void delete(int id);
    UpdateBlacklistResponse update(UpdateBlacklistRequest request);
    GetBlacklistResponse getById(int id);
    List<GetListBlacklistResponse> findByApplicantId(int applicantId);
}

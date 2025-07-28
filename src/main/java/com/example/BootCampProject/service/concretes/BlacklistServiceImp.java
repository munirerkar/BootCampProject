package com.example.BootCampProject.service.concretes;


import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.entity.Blacklist;
import com.example.BootCampProject.repository.BlacklistRepository;
import com.example.BootCampProject.service.abstracts.BlacklistService;
import com.example.BootCampProject.service.dtos.requests.Blacklist.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.requests.Blacklist.UpdateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.Application.GetListApplicationResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.CreatedBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.GetListBlacklistResponse;
import com.example.BootCampProject.service.dtos.responses.Blacklist.UpdateBlacklistResponse;
import com.example.BootCampProject.service.mappers.ApplicationMapper;
import com.example.BootCampProject.service.mappers.BlacklistMapper;
import com.example.BootCampProject.service.rules.BlacklistBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlacklistServiceImp implements BlacklistService {
    private final BlacklistRepository blacklistRepository;
    private final BlacklistBusinessRules rules;

    public BlacklistServiceImp(BlacklistRepository blacklistRepository, BlacklistBusinessRules rules) {
        this.blacklistRepository = blacklistRepository;
        this.rules = rules;
    }

    @Override
    public CreatedBlacklistResponse add(CreateBlacklistRequest request) {
        rules.checkIfApplicantAlreadyBlacklisted(request.getApplicantId());
        rules.checkIfReasonIsNotBlank(request.getReason());
        Blacklist blacklist = BlacklistMapper.INSTANCE.createBlacklistRequestToBlacklist(request);
        Blacklist createdBlacklist = blacklistRepository.save(blacklist);
        return BlacklistMapper.INSTANCE.createBlacklistResponseFromBlacklist(createdBlacklist);
    }

    @Override
    public List<GetListBlacklistResponse> getAll() {
        List<Blacklist> blacklists = blacklistRepository.findAll();
        List<GetListBlacklistResponse> response = blacklists.stream().map(BlacklistMapper.INSTANCE::getAllBlacklistResponsesFromBlacklist).collect(Collectors.toList());
        return response;
    }

    @Override
    public void delete(int id) {
        blacklistRepository.deleteById(id);
    }

    @Override
    public UpdateBlacklistResponse update(UpdateBlacklistRequest request) {
        Blacklist blacklist = BlacklistMapper.INSTANCE.updateBlacklistRequestToBlacklist(request);
        blacklistRepository.findById(blacklist.getId()).orElseThrow(() -> new RuntimeException("Blacklist not found with id: " + blacklist.getId()));
        Blacklist updated = blacklistRepository.save(blacklist);
        return BlacklistMapper.INSTANCE.updateBlacklistResponseFromBlacklist(updated);
    }

    @Override
    public GetBlacklistResponse getById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id).orElseThrow(() -> new RuntimeException("Blacklist not found id: " + id));
        return BlacklistMapper.INSTANCE.getBlacklistResponseFromBlacklist(blacklist);
    }

    @Override
    public List<GetListBlacklistResponse> findByApplicantId(int applicantId) {
        List<Blacklist> blacklists = blacklistRepository.findByApplicantId(applicantId);
        List<GetListBlacklistResponse> responses = blacklists.stream().map(BlacklistMapper.INSTANCE::getAllBlacklistResponsesFromBlacklist).collect(Collectors.toList());
        return responses;
    }
}

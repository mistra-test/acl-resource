package com.example.aclresource.controller;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Party;
import com.example.aclresource.service.PartyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/acl/party")
public class PartyController {

    @Autowired PartyService partyService;

    @PostMapping
    public Party save(@RequestBody PartyDTO dto) {
        try {
            return partyService.save(PartyDTO.toParty(dto));
        } catch (InvalidEntityException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        }
    }

    @GetMapping
    public List<Party> findAll() {
        return partyService.findAll();
    }
}

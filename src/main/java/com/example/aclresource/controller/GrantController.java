package com.example.aclresource.controller;

import com.example.aclresource.model.Grant;
import com.example.aclresource.service.GrantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/acl/grant")
public class GrantController {

    @Autowired GrantService grantService;

    @GetMapping("/{id}")
    public Optional<Grant> findById(Long id) {
        return grantService.findById(id);
    }

    @PostMapping
    public Grant save(@RequestBody GrantDTO grantDTO) {
        // try {
        return grantService.save(GrantDTO.toGrant(grantDTO));
        // } catch (InvalidUserException e) {
        //     throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        // }
    }
}

package com.example.aclresource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acl/party")
public class PartyController {

    // @PostMapping
    // public User save(@RequestBody UserDTO user) {
    //     try {
    //         return userService.save(UserDTO.toUser(user));
    //     } catch (InvalidUserException e) {
    //         throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
    //     }
    // }

    // @PostMapping("/authenticate")
    // public Optional<User> findByEmailAndPassword(@RequestBody EmailAndPasswordResponse response)
    // {
    //     return userService.findByEmailAndPassword(response.getEmail(), response.getPassword());
    // }

    // @GetMapping("/{id}")
    // public Optional<User> findById(Long id) {
    //     return userService.findById(id);
    // }
}

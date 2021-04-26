package com.example.aclresource.controller;

import lombok.Data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
class EmailAndPasswordResponse {
    String email;
    String password;
}

@RestController
@RequestMapping("/acl/group")
public class GroupController {

    // @Autowired UserService userService;

    // crea una direttiva
    // distruggi una direttiva
    // rendi le direttive

    // crea un gruppo
    // inserisci una "direttiva" a un gruppo
    // inserisci un gruppo come sottoinsieme di un gruppo ** attenzione, relazione antiriflessiva e
    // antisimmetrica**
    // rendi tutti i gruppi

    // associa un id utente a un gruppo
    // d

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

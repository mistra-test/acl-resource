package com.example.aclresource.controller;

import com.example.aclresource.model.Party;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class PartyDTO {
    private Long id;

    private String name;

    public static Party toParty(PartyDTO dto) {
        return new Party(dto.getId(), dto.getName());
    }
}

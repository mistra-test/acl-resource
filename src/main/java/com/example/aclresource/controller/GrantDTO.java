package com.example.aclresource.controller;

import com.example.aclresource.model.Grant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class GrantDTO {
    private Long id;

    private String name;

    public static Grant toGrant(GrantDTO dto) {
        Grant grant = new Grant();

        grant.setId(dto.getId());
        grant.setName(dto.getName());

        return grant;
    }
}

package com.company.assaka.dto;

import com.company.assaka.domain.Admin;
import lombok.Data;

@Data
public class AdminDto {
    private String username;
    public AdminDto(Admin admin){
        username = admin.getUsername();
    }
}

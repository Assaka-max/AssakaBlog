package com.company.assaka.service;

import com.company.assaka.domain.Admin;
import com.company.assaka.dto.AdminDto;
import com.company.assaka.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AdminMapper adminMapper;

    public AdminDto AdminAuth(String username, String password){
        Admin admin = adminMapper.findAdmin(username, password);
        return new AdminDto(admin);
    }
}

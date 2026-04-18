package com.company.assaka.service;

import com.company.assaka.dto.UserDto;

public interface UserService {
    UserDto findUserByName(String username);
}

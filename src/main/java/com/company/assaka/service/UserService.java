package com.company.assaka.service;

import com.company.assaka.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findUserByName(String username);

    List<UserDto> findUserListByName(String username);
}

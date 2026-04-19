package com.company.assaka.service;

import com.company.assaka.domain.User;
import com.company.assaka.dto.UserDto;
import com.company.assaka.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    @Override
    public UserDto findUserByName(String username) {
        User user = userMapper.findByName(username);
        if(user == null) throw new RuntimeException("用户名不存在");
        return new UserDto(user);
    }

    @Override
    public List<UserDto> findUserListByName(String username) {
        List<User> userList = userMapper.findUserListByName(username);
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        for(User user : userList) userDtoList.add(new UserDto(user));
        return userDtoList;
    }
}

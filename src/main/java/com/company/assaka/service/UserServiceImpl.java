package com.company.assaka.service;

import com.company.assaka.domain.User;
import com.company.assaka.dto.UserDto;
import com.company.assaka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDto findUserByName(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null) throw new RuntimeException("用户名不存在");
        return new UserDto(user);
    }
}

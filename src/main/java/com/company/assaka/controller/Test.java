package com.company.assaka.controller;

import com.company.assaka.dto.UserDto;
import com.company.assaka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class Test{
    private final UserService userService;

    @GetMapping("/test")
    public UserDto test(@RequestParam String username){
        return userService.findUserByName(username);
    }
}

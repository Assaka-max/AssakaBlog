package com.company.assaka.controller;

import com.company.assaka.dto.Result;
import com.company.assaka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){

    }
}

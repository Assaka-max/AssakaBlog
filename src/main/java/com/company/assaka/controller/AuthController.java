package com.company.assaka.controller;

import com.company.assaka.dto.Result;
import com.company.assaka.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /**
     * 对应 test.html 的【获取游客Token】按钮
     */
    @PostMapping("/visitor")
    public Result generateVisitorToken() {
        Map<String, String> tokenMessage = new HashMap<>();
        tokenMessage.put("userType", "visitor");
        String realJwtToken = JwtUtil.generateToken(tokenMessage);
        Map<String, String> data = new HashMap<>();
        data.put("token", realJwtToken);
        return Result.success(data);
    }

    /**
     * 对应 test.html 的【登录表单提交】
     */
    @PostMapping("/login")
    public Result adminLogin(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");

        // 极简验证：假设你的管理员账号密码是 admin / 123
        if ("admin".equals(username) && "123".equals(password)) {
            Map<String, String> tokenMessage = new HashMap<>();
            tokenMessage.put("userType", "admin");
            String realJwtToken = JwtUtil.generateToken(tokenMessage);
            Map<String, String> data = new HashMap<>();
            data.put("token", realJwtToken);
            return Result.success(data);
        } else {
            return Result.error("账号或密码错误");
        }
    }

    /**
     * 对应 test.html 的【测试管理员接口】
     * 这个接口路径故意带 /admin，用来测试拦截器拦截
     */
    @GetMapping("/admin/test")
    public Result testAdminApi() {
        return Result.success("恭喜！你成功携带管理员身份穿透了拦截器！");
    }

    /**
     * 对应 test.html 的【测试公开接口】
     */
    @GetMapping("/public/test")
    public Result testPublicApi() {
        return Result.success("公开接口，只要带Token就能进！");
    }
}

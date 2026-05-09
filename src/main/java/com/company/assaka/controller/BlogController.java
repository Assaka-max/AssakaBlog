package com.company.assaka.controller;

import com.company.assaka.dto.BlogDto;
import com.company.assaka.dto.Result;
import com.company.assaka.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/all")
    public Result getAllBlogs(){
        List<BlogDto> blogDtos = blogService.getAllBlogs();
        if(blogDtos == null) return Result.error("无法找到任何文章");
        return Result.success(blogDtos);
    }
}

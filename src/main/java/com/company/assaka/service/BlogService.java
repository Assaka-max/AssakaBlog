package com.company.assaka.service;

import com.company.assaka.domain.Blog;
import com.company.assaka.dto.BlogDto;
import com.company.assaka.mapper.BlogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogMapper blogMapper;

    public List<BlogDto> getAllBlogs(){
        List<BlogDto> blogDtos = new ArrayList<>();
        List<Blog> blogs = blogMapper.getAllBlogs();
        for(Blog blog : blogs) blogDtos.add(new BlogDto(blog));
        return blogDtos;
    }
}

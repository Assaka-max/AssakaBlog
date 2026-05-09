package com.company.assaka.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.assaka.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @Select("SELECT * FROM t_blog")
    List<Blog> getAllBlogs();

}

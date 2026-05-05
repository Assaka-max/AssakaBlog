package com.company.assaka.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.assaka.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("SELECT * FROM t_admin WHERE username = #{username} AND password = #{password}")
    Admin findAdmin(@Param("username") String username, @Param("password") String password);
}

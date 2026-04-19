package com.company.assaka.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.assaka.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User findByName(@Param("username") String username);

    default List<User> findUserListByName(String username){
        return selectList(new LambdaQueryWrapper<User>()
                .like(User::getUsername, username)
        );
    }
}

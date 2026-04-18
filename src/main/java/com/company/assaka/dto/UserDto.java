package com.company.assaka.dto;

import com.company.assaka.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public UserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.createTime = user.getCreateTime();
    }
}

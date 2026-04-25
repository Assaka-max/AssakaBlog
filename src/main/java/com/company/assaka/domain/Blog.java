package com.company.assaka.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_blog")
public class Blog {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String firstPicture;
    private Boolean isPublished;
    private Long views;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer typeId;
    private Long userId;
}

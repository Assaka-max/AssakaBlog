package com.company.assaka.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogDto {
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

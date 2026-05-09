package com.company.assaka.dto;

import com.company.assaka.domain.Blog;
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

    public BlogDto(Blog blog){
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.description = blog.getDescription();
        this.firstPicture = blog.getFirstPicture();
        this.isPublished = blog.getIsPublished();
        this.views = blog.getViews();
        this.createTime = blog.getCreateTime();
        this.updateTime = blog.getUpdateTime();
        this.typeId = blog.getTypeId();
        this.userId = blog.getUserId();
    }
}

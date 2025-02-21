package com.drive.flashbox.dto;

import java.time.LocalDateTime;

import com.drive.flashbox.entity.Box;
import com.drive.flashbox.entity.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PictureDto {

    private Long pid;

    private String name;

    private LocalDateTime uploadDate;

    private String imageUrl;

    private User user;

    private Box box;
}

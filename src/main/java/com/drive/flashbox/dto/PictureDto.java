package com.drive.flashbox.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PictureDto {
    private Long pid;
    private String name;
    private LocalDateTime uploadDate;
    private String imageUrl;
    private Long userId; 
    private Long boxId;
}

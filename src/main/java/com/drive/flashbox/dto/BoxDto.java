package com.drive.flashbox.dto;

import com.drive.flashbox.entity.Box;
import com.drive.flashbox.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class BoxDto {
    private String name;
    
    private LocalDateTime eventStartDate;

    private LocalDateTime eventEndDate;
    
    public BoxDto(String name, LocalDate eventStartDate, LocalDate eventEndDate) {
    	this.name = name;
    	this.eventStartDate = eventStartDate.atStartOfDay();
    	this.eventEndDate = eventEndDate.atStartOfDay().plusDays(1).minusSeconds(1); // LocalDate를 LocalDateTime으로 변환
    }
    
    // dto -> entity
    public static Box toEntity(BoxDto boxDto, User user) {
    	return new Box(boxDto.getName(), boxDto.getEventStartDate(), boxDto.getEventEndDate(), user);
    	
    }
}

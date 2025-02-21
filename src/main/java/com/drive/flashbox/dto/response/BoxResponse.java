package com.drive.flashbox.dto.response;

import java.time.LocalDate;

import com.drive.flashbox.dto.request.BoxRequest;
import com.drive.flashbox.entity.Box;
import com.drive.flashbox.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoxResponse {
	private Long bid;
	
	private String name;
    
    private LocalDate eventStartDate;

    private LocalDate eventEndDate;
    
    // entity -> dto
    public static BoxResponse from(Box box) {
    	return new BoxResponse(box.getBid(), box.getName(), box.getEventStartDate().toLocalDate(), box.getEventEndDate().toLocalDate());
    }
}

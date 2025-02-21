package com.drive.flashbox.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drive.flashbox.dto.BoxDto;
import com.drive.flashbox.entity.Box;
import com.drive.flashbox.service.BoxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoxController {
	private final BoxService boxService;
	
	// box 목록 페이지에서 생성버튼 누르면 newBox.html 로 보내면 되는데 아직 없어서 테스트용 메서드
	@GetMapping("/box")
	public String newBox() {
		return "newBox";
	}
	
	// box 생성
	@PostMapping("/box")
	public String createBox(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "eventStartDate") 
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventStartDate,
            @RequestParam(name = "eventEndDate") 
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventEndDate
    ) {
		
		BoxDto boxDto = new BoxDto(name, eventStartDate, eventEndDate);
		
		Box box = boxService.createBox(boxDto);
		
		// 생성 후 box 목록 페이지로 가야하는 데 아직 없어서 임의로 지정
		return "redirect:/box";
	}
}

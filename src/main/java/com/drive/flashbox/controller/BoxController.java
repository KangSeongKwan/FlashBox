package com.drive.flashbox.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		// LocalDate를 LocalDateTime으로 변환
		LocalDateTime startDateTime = eventStartDate.atStartOfDay();
        LocalDateTime endDateTime = eventEndDate.atStartOfDay().plusDays(1).minusSeconds(1); // 이벤트 종료 날짜는 자정 직전으로 설정
		Box box = boxService.createBox(name, startDateTime, endDateTime);
		
		// 생성 후 box 목록 페이지로 가야하는 데 아직 없어서 임의로 지정
		return "redirect:/box";
	}
}

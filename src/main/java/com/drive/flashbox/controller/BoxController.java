package com.drive.flashbox.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drive.flashbox.dto.request.BoxRequest;
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
	
	// box 생성 기능
	@PostMapping("/box")
	public String createBox(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "eventStartDate") 
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventStartDate,
            @RequestParam(name = "eventEndDate") 
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventEndDate,
            ModelMap modelMap
    ) {
		
		BoxRequest boxDto = new BoxRequest(name, eventStartDate, eventEndDate);
		boxService.createBox(boxDto);
		
		// 생성 후 box 목록 페이지로 가야하는 데 아직 없어서 임의로 지정
		return "redirect:/box";
	}
	
	// box 수정 페이지
	@GetMapping("/box/{bid}")
	public String editbox(@PathVariable("bid") Long bid, ModelMap modelMap) {
		
		// 박스 정보 담아서 수정 페이지 이동
		modelMap.addAttribute("box",boxService.getBox(bid));
		
		return "editBox";
	}
	
	// box 수정 기능
	@PutMapping("/box/{bid}")
	public String updateBox(@PathVariable("bid") Long bid,
							@RequestParam(name = "name") String name,
				            @RequestParam(name = "eventStartDate") 
				            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventStartDate,
				            @RequestParam(name = "eventEndDate") 
				            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventEndDate
	) {
		
		BoxRequest boxDto = new BoxRequest(name, eventStartDate, eventEndDate);
		boxService.updateBox(bid, boxDto);

		return "redirect:/box/" + bid;
	}
}

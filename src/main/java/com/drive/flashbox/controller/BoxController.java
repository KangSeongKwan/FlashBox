package com.drive.flashbox.controller;

import com.drive.flashbox.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class BoxController {
	private final BoxService boxService;
	
	// box 목록 페이지에서 생성버튼 누르면 newBox.html 로 보내면 되는데 아직 없어서 테스트용 메서드
	@GetMapping("/box")
	public String newBox() {
		return "newBox";
	}

	// box 다운
	@GetMapping("/box/{bid}/download")
	@ResponseBody
	public Map<String, Object> downloadBox(@PathVariable Long bid,
										   @RequestParam(value = "uid", required = false) Long uid) {
		if (uid == null) {
			uid = 1L; // 기본 테스트 사용자
		}
		String downloadUrl = boxService.generateZipAndGetPresignedUrl(bid, uid);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "박스 다운로드 링크 생성에 성공하였습니다");
		response.put("downloadUrl", downloadUrl);
		response.put("status", 200);
		return response;
	}
}

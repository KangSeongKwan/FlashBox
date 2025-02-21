package com.drive.flashbox.controller;

import com.drive.flashbox.dto.PictureDto;
import com.drive.flashbox.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/box")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @GetMapping("/{bid}/picture/{pid}")
    public ResponseEntity<PictureDto> getPictureDetails(@PathVariable Long bid, @PathVariable Long pid) {
        PictureDto pictureDTO = pictureService.getPictureDetails(bid, pid);
        return ResponseEntity.ok(pictureDTO);
    }
}
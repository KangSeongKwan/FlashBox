package com.drive.flashbox.controller;

import com.drive.flashbox.dto.PictureDTO;
import com.drive.flashbox.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/box")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @GetMapping("/{bid}/picture/{pid}")
    public ResponseEntity<PictureDTO> getPictureDetails(@PathVariable Long bid, @PathVariable Long pid) {
        PictureDTO pictureDTO = pictureService.getPictureDetails(bid, pid);
        return ResponseEntity.ok(pictureDTO);
    }
}
package com.drive.flashbox.service;

import com.drive.flashbox.dto.PictureDto;
import com.drive.flashbox.entity.Picture;
import com.drive.flashbox.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;

    @Transactional(readOnly = true)
    public PictureDto getPictureDetails(Long bid, Long pid) {
        Picture picture = pictureRepository.findByPidAndBoxBid(pid, bid)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지 또는 박스를 찾을 수 없습니다."));
        
        return PictureDto.builder()
                .pid(picture.getPid())
                .name(picture.getName())
                .uploadDate(picture.getUploadDate())
                .imageUrl(picture.getImageUrl())
                .userId(picture.getUser().getId())
                .boxId(picture.getBox().getBid())
                .build();
    }
    
    @Transactional
    public void deletePicture(Long bid, Long pid) {
        Picture picture = pictureRepository.findByPidAndBoxBid(pid, bid)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지 또는 박스를 찾을 수 없습니다."));
        
        pictureRepository.delete(picture);
    }
    
}
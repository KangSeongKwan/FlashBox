package com.drive.flashbox.repository;

import com.drive.flashbox.entity.Picture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    // bid와 pid로 Picture를 찾는 메서드
    Optional<Picture> findByPidAndBid(Long pid, Long bid);
}

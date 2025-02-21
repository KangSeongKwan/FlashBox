package com.drive.flashbox.service;

import org.springframework.stereotype.Service;

import com.drive.flashbox.dto.BoxDto;
import com.drive.flashbox.entity.Box;
import com.drive.flashbox.entity.User;
import com.drive.flashbox.entity.enums.RoleType;
import com.drive.flashbox.repository.BoxRepository;
import com.drive.flashbox.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoxService {
	final private BoxRepository boxRepository;
	final private UserRepository userRepository;

	@Transactional
	public Box createBox(BoxDto boxDto) {
		// 유저가 없으면 생성이 안되서 임의로 1번 유저가 생성했다고 가정
		User user = userRepository.getReferenceById(1L);

		Box box = BoxDto.toEntity(boxDto, user);
		
		// BoxUser에 생성한 유저와 OWNER role 등록하는 메서드
		box.addBoxUser(user, RoleType.OWNER);
		
		return boxRepository.save(box);
	}
	
}

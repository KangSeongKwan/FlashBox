package com.drive.flashbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drive.flashbox.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

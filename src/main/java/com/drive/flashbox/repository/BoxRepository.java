package com.drive.flashbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drive.flashbox.entity.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

}

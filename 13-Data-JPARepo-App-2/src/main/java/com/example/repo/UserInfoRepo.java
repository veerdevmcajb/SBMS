package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

}

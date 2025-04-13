package com.conectapro.conectapro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectapro.conectapro.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByLogin(String login);
	
}

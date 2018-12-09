package com.startups.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startups.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
}

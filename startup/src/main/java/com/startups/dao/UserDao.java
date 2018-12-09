package com.startups.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.startups.domain.Project;
import com.startups.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
}

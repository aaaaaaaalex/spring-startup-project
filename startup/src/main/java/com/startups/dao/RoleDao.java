package com.startups.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startups.domain.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}

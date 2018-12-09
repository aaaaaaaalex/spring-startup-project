package com.startups.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.startups.domain.Pledge;
import com.startups.domain.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {

	
	@Query("SELECT p FROM Project p WHERE p.active=:active")
	List<Project> findActiveProjects(@Param("active") boolean active);
	
	
	List<Pledge> findPledgesByProjectId(@Param("projectId") int projectId);
	
	@Query("UPDATE Project "
		  + "SET description = :description "
		  + "WHERE projectId = :projectId ")
	String editDesc(@Param("description") String description, @Param("projectId") int projectId);

}

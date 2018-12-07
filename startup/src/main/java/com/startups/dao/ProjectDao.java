package com.startups.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.startups.domain.Pledge;
import com.startups.domain.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {

	
	@Query("SELECT * FROM Project p WHERE p.active=:active")
	List<Project> findAllActive(@Param("active") boolean active);
	
	@Query("SELECT Pledges FROM Project pr WHERE p.id=:projId")
	List<Pledge> findAllPledges(int projId);
	
	String editDesc(String s);

}

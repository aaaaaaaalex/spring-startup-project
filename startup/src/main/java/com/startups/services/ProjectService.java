package com.startups.services;

import java.util.List;

import com.startups.domain.Pledge;
import com.startups.domain.Project;
import com.startups.domain.User;

public interface ProjectService {
	
	//Functions executable on Projects
	List<Project> findAllActive(boolean active);
	List<Pledge> findProjectPledges(int id);
	String editDesc(String s);
}

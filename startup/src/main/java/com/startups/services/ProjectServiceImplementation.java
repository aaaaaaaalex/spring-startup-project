package com.startups.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.startups.dao.PledgeDao;
import com.startups.dao.ProjectDao;
import com.startups.domain.Pledge;
import com.startups.domain.Project;

public class ProjectServiceImplementation implements ProjectService{

	@Autowired 
	ProjectDao projDao;
	
	@Override
	public List<Project> findAllActive(boolean active){
		return projDao.findAllActive(active);
	}
	
	@Override
	public List<Pledge> findProjectPledges(int id){
		return projDao.findAllPledges(id);
	};
	
	@Override
	public String editDesc(String s) {
		return projDao.editDesc(s);
		
	};
}

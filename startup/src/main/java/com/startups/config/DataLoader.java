package com.startups.config;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.startups.dao.RoleDao;
import com.startups.dao.UserDao;
import com.startups.domain.Project;
import com.startups.domain.Role;
import com.startups.domain.User;
import com.startups.services.PledgeService;
import com.startups.services.ProjectService;


@Component	
public class DataLoader implements ApplicationRunner {

		@Autowired
		ProjectService projectService;
		
		@Autowired
		UserDao userDao;
		
		@Autowired
		PasswordEncoder passwordEncoder;
		
		@Autowired
		RoleDao roleDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Role role1 = new Role("minnie.mouse@cit.ie", "ROLE_API");
		Role role2 = new Role("mickey.mouse@cit.ie", "ROLE_USER");
		Role role3 = new Role("donald.duck@cit.ie", "ROLE_ADMIN");
		roleDao.save(role1);
		roleDao.save(role2);
		roleDao.save(role3);
		
		
		User user1 = new User(1, "Minnie", "minnie.mouse@cit.ie",null, null, passwordEncoder.encode("password"));
		User user2 = new User(2, "Mickie", "mickthedick.mouse@cit.ie",null, null, passwordEncoder.encode("password"));
		User user3 = new User(3, "Goofy", "cucklord@cit.ie",null, null, passwordEncoder.encode("password"));

		
		
		Date d = new Date();
		Project p1 = new Project(1, "Super Interesting Project", "Dis cool", 50, d, true, user1);
		Project p2 = new Project(2, "Super second Project", "Dis also cool", 500, d, true, user2);
		Project p3 = new Project(3, "Project tree", "Uhhh yuh very cool", 350, d, true, user3);
		
		
		List<Project> user1Projects = new ArrayList<Project>();
		user1Projects.add(p1);
		user1.setProjects(user1Projects);
		
		List<Project> user2Projects = new ArrayList<Project>();
		user2Projects.add(p2);
		user2.setProjects(user2Projects);
		
		List<Project> user3Projects = new ArrayList<Project>();
		user3Projects.add(p3);
		user3.setProjects(user3Projects);

		
		userDao.save(user1);
		userDao.save(user2);
		userDao.save(user3);
		
		projectService.save(p1);
		projectService.save(p2);
		projectService.save(p3);

		}

	}
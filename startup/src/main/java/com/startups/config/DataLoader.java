package com.startups.config;
import java.util.Date;

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
		PledgeService pledgeService;
		
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
			
		User user1 = new User(0, "Minnie", "minnie.mouse@cit.ie",null, null, passwordEncoder.encode("password"));
		User user2 = new User(1, "Mickie", "mickthedick.mouse@cit.ie",null, null, passwordEncoder.encode("password"));
		User user3 = new User(2, "Goofy", "cucklord@cit.ie",null, null, passwordEncoder.encode("password"));
		userDao.save(user1);
		userDao.save(user2);
		userDao.save(user3);
			
		Date d = new Date();
		Project p1 = new Project(0, "Super Interesting Project", "Dis cool", 50, d, true, user1);
		Project p2 = new Project(1, "Super second Project", "Dis also cool", 500, d, true, user2);
		Project p3 = new Project(2, "Project tree", "Uhhh yuh very cool", 350, d, true, user3);
			
		projectService.save(p1);
		projectService.save(p2);
		projectService.save(p3);
						
		}

	}
package com.startups.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {



	// --------------------------------------- Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	
	@Column(nullable=false, unique=false)
	private String name;
	
	
	@Column(nullable=false, unique=true)
	@Email
	private String email;
	
	
	@Column
	@Size(min=8)
	private String password;
	
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Project> projects;
	
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pledge> pledges;
		
	
	
	// --------------------------------------- Constructors
	public User(int userId, String name, String email, List<Project> projects, List<Pledge> pledges, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.projects = projects;
		this.pledges = pledges;
		this.password = password;
	}
	public User(String name) {
		this.name = name;
	}
	public User() {}
	
	
	
	// --------------------------------------- GET / SET
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Pledge> getPledges() {
		return pledges;
	}
	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}

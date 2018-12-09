package com.startups.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	
	
	// ------------------------------------------ class variables
	@Id
	String roleEmail;
	
	
	@Column
	String roleDescription;


	
	// ----------------------------------------- get / sets
	public String getUserEmail() {
		return roleEmail;
	}


	public void setUserEmail(String userEmail) {
		this.roleEmail = userEmail;
	}


	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}


	
	// ---------------------------------------- constructor
	public Role(String roleEmail, String roleDescription) {
		this.roleEmail = roleEmail;
		this.roleDescription = roleDescription;
	}
	public Role() {
		super();
	}
}

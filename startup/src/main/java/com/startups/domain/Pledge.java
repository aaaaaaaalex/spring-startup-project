package com.startups.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pledge {
	
	@Column(nullable=false)
	public String user;
	
	@Column
	public double amount;
	
	
	public Pledge(String user, double amount) {
		super();
		this.user = user;
		this.amount = amount;
	}
	
	public Pledge() {}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

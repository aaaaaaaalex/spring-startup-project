package com.startups.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Pledge {
	
	
	
	// ----------------------------------------- class variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pledgeId;
	
	@Column
	private double amount;
	
	
	
	// ---------------------------------------- constructors
	public Pledge(int pledgeId, double amount) {
		super();
		this.pledgeId = pledgeId;
		this.amount = amount;
	}
	public Pledge() {}
	
	
	
	// --------------------------------------- gets / sets
	public int getPledgeId() {
		return pledgeId;
	}
	public void setpledgeId(int userId) {
		this.pledgeId = userId;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

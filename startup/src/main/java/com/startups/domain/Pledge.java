package com.startups.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="projectId")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	
	
	// ---------------------------------------- constructors
	public Pledge(int pledgeId, double amount, Project project, User user) {
		super();
		this.pledgeId = pledgeId;
		this.amount = amount;
		this.project = project;
		this.user = user;
	}
	public Pledge() {}
	
	
	
	// --------------------------------------- gets / sets
	public int getPledgeId() {
		return pledgeId;
	}
	public void setPledgeId(int pledgeId) {
		this.pledgeId = pledgeId;
	}
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

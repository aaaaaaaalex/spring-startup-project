package com.startups.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Project {


	
	// ------------------------------------ Class Variables
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int projId;
	
	@NotNull
	@Column
	private String projName;
	
	@Column
	private String description;
	
	@NotNull
	@Column
	private double targetAmount;
	
	private Date doc;
	
	@Column
	private boolean active;
	
	@OneToMany
	private List<Pledge> pledges;
	
	
	
	// ------------------------------------ Constructor
	public Project(int projId, String projName, String description, double targetAmount, Date doc, boolean active) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.description = description;
		this.targetAmount = targetAmount;
		this.doc = doc;
		this.active = active;
	}
	public Project() {}

	
	
	// ------------------------------------ Get / Set
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	
	
	public List<Pledge> getPledges() {
		return pledges;
	}
	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public double getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}
	
	
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}

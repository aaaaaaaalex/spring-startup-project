package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

	@NotNull
	@Column
	public String projName;
	@Column
	public String description;
	@NotNull
	@Column
	public double targetAmount;
	public Date doc;
	@Column
	public boolean active;
	
	@OneToMany
	public List<Pledge> pledges;
	
	
	public Project(String projName, String description, double targetAmount, Date doc, boolean active) {
		super();
		this.projName = projName;
		this.description = description;
		this.targetAmount = targetAmount;
		this.doc = doc;
		this.active = active;
	}
	
	public Project() {}
	
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
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

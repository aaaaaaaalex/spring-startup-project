package domain;

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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable=false, unique=false)
	public String name;
	
	@Column(nullable=false, unique=true)
	public Email email;
	
	@Column
	@Size(min=8)
	public String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="county", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	public List<Project> projects;
	
	
	public User(int userId, String name, Email email, List<Project> projects) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.projects = projects;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User() {}
	
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
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
}

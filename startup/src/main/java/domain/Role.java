package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	String userEmail;
	
	
	@Column
	String roleDescription;


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}


	public Role(String userEmail, String roleDescription) {
		this.userEmail = userEmail;
		this.roleDescription = roleDescription;
	}


	public Role() {
		super();
	}
}

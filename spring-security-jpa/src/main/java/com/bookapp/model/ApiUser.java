package com.bookapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ApiUser {
	//Inbuilt clas
//	User user;

	private String username;
	private String password;
	@Id
	@GeneratedValue
	private Integer userId;
	private String email;
//	@ManyToMany(cascade = CascadeType.ALL)
//	// to have only one junction table
//	@JoinTable(name="user_role",
//			joinColumns = @JoinColumn(name="user_id"),
//			inverseJoinColumns = @JoinColumn(name="role_id")			
//			)
	private Set<String> roles;
	
	public ApiUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiUser(String username, String password, String email, Set<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ApiUser [username=" + username + ", password=" + password + ", userId=" + userId + ", email=" + email
				+ ", roles=" + roles + "]";
	}

	
	
	
}

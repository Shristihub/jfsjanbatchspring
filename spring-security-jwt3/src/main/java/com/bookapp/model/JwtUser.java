package com.bookapp.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="jwtuser")
public class JwtUser {

	
	private String username;
	private String email;
	@Id
	@GeneratedValue
	private Integer userId;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorities",joinColumns = {
			@JoinColumn(name="user_id")
	})
	private List<String> authorities;
	
	public JwtUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtUser(String username, String email, String password, List<String> authorities) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the authorities
	 */
	public List<String> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "JwtUser [username=" + username + ", email=" + email + ", userId=" + userId + ", password=" + password
				+ ", authorities=" + authorities + "]";
	}
	
	
	
	
}

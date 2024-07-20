package com.bookapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Role {

	String roleName;
	@Id
	@GeneratedValue
	Integer roleId;
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleId=" + roleId + "]";
	}
	
	
}

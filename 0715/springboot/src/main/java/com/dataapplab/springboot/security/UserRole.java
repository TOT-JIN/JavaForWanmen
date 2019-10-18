package com.dataapplab.springboot.security;

public class UserRole {
	Account user;
	Role role;
	
	public Account getUser() {
		return user;
	}
	public Role getRole() {
		return role;
	}
	public void setUser(Account user) {
		this.user = user;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}

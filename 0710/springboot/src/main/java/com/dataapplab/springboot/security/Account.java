package com.dataapplab.springboot.security;

/**
 * SQL=> data => object
 * @author 万门大学
 *
 */
public class Account {
	int    userId;   //user_id
	String userName; //user_name
	String password;
	String email;
	String avatar;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}

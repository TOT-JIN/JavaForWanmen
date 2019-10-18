package com.dataapplab.springboot.security;

import java.util.ArrayList;
import java.util.List;

public class Account
{
	private int id;
	private String userName;
	private String avatar;
	private String email;
	private String password;
	private String resetToken;
	private boolean enabled;
	private List<Role> roles;
	
	public Account(){
		this.roles= new ArrayList();
	}

	public int getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public String getAvatar() {
		return avatar;
	}

	public boolean isEnabled() {
		return enabled;
	}	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getResetToken()
	{
		return resetToken;
	}
	
	public void setResetToken(String passwordResetToken)
	{
		this.resetToken = passwordResetToken;
	}
	
    @Override
    public String toString() {
        return "User Account [username=" + userName + ", password=" + password + "]";
    }
	public List<Role> getRoles() {
		return roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		 if (obj == null)
			 return false;
		 if (obj == this)
			 return true;
		 if (!(obj instanceof Account))
			 return false;
		 
		 Account targetAccount = (Account) obj;
		 if(targetAccount.email.equals(this.email) || targetAccount.userName.equals(this.userName)){
			 return true;
		 }
		 
		 return false;
	}
}
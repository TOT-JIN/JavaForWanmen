package com.dataapplab.springboot.security;


public class Account
{
	private int id;
	private String userName;
	private String avatar;
	private String email;
	private String password;
	private String resetToken;
	private boolean enabled;

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
}
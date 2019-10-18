package com.dataapplab.springboot.security;

import java.util.List;
public class Role
{
	private Integer id;
	private String name;
	private String description;
		
	private List<User> users;

	private List<Permission> permissions;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions()
	{
		return permissions;
	}

	public void setPermissions(List<Permission> permissions)
	{
		this.permissions = permissions;
	}
	
	
}
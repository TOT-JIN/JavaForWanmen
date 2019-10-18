package com.dataapplab.springboot.security;

import java.util.List;
public class Role
{
	private Integer id;
	private String name;
	private String description;
		
	private List<Account> users;
//	private List<Permission> permissions;

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

	public List<Account> getUsers() {
		return users;
	}

	public void setUsers(List<Account> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
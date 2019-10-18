package com.dal.example;
//import envapulationExample.Employee;
import envapulationExample.*;
public class Director extends Employee{
	private String departName;

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String name, String sex, int age, String comName,String departName) {
		//super(name, sex, age, comName);
		super.name=name;
		this.departName=departName;
		// TODO Auto-generated constructor stub
	}
	
}

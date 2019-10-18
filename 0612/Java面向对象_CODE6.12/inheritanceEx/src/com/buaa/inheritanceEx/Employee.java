package com.buaa.inheritanceEx;

public class Employee extends Person {
	private double salary;///////

	public Employee() {
		super();
		System.out.println("Employee类构造函数");//////
	
	}

	public Employee(String name, char sex, int age) {
		super(name, sex, age);///////
	
	}

	public Employee(String name, char sex, int age, double salary) {
		super(name, sex, age);
		this.salary = salary;////////

	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDetails() {
		return super.getDetails()+this.getSalary();/////////
		//return super.name + "薪水是："+this.salary;
		// return super.getName()+ "薪水是：+"this.getSalary(); //also works
        // return super.getDetails()+"薪水是："+this.getSalary(); //also work
	}
}

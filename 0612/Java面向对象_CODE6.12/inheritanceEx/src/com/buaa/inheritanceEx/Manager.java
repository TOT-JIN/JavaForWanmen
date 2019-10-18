package com.buaa.inheritanceEx;

public class Manager extends Employee{//////

	private String department;///////

	public Manager() {///////
		super();
		System.out.println("Manager类构造函数");
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, char sex, int age, double salary) {
		super(name, sex, age, salary);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, char sex, int age) {
		super(name, sex, age);
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String name, char sex, int age, double salary,String department) {
		super(name, sex, age, salary);
		this.department=department;
		// TODO Auto-generated constructor stub
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDetails() {////
		return super.getDetails()+this.getDepartment();/////////
	//	 return super.getName()+ "薪水是："+super.getSalary()+this.department; //also works
     //    return super.getDetails()+"薪水是："+super.getSalary()+this.getDepartment(); //also work
	}

}

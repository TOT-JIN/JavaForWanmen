package com.buaa.inheritanceEx;

public class Deirector extends Manager{///////

	private int carAllowance;//////

	public Deirector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deirector(String name, char sex, int age, double salary, String department) {
		super(name, sex, age, salary, department);
		// TODO Auto-generated constructor stub
	}

	public Deirector(String name, char sex, int age, double salary) {
		super(name, sex, age, salary);
		// TODO Auto-generated constructor stub
	}

	public Deirector(String name, char sex, int age) {
	//	super(name, sex, age);
		int i=0;
		super(name, sex, age);
		// TODO Auto-generated constructor stub
		System.out.println("Deirector类构造函数");
	}

	public Deirector(String name, char sex, int age, double salary, String department,int carAllowance) {
		super(name, sex, age, salary, department);
		// TODO Auto-generated constructor stub
		this.carAllowance=carAllowance;
	}
	
	public int getCarAllowance() {
		return carAllowance;
	}

	public void setCarAllowance(int carAllowance) {
		this.carAllowance = carAllowance;
	}
	
	public String getDetails() {
		return super.getDetails()+this.getCarAllowance();
	}
}

package domain;  //包的定义

//import java.util.*;  //引入Java包里的util包中的类和接口；

import java.util.Set;  //引入具体的类

public class Company {

	/**
	 * @param args
	 */
	private Set<Vehicle> vehicles;  //公司拥有0或者多种交通工具，“has关系”
	private Set<Employee> employees;

	public Company() {
		super();
	}

	public Company(Set<Employee> employees, Set<Vehicle> vehicles) {
		super();
		this.employees = employees;
		this.vehicles = vehicles;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

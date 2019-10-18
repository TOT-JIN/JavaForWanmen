package com.buaa.example;

public class Dog {
	private String name;
	private String strain;

	public Dog() {
		super();
	}

	public Dog(String name, String type) {
		this.name = name;
		this.strain = type;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String type) {
		this.strain = type;
	}

}

package com.buaa.inheritanceEx;

class Person {
	protected String name;

	protected char sex;

	protected int age;

	public Person() {
		super();
		System.out.println("父类构造函数");//////
	}

	public Person(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String toString() {
		return "姓名：" + name + "性别：" + sex + "年龄：" + age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String getDetails() {
		return "这个人是："+name;
	}
}

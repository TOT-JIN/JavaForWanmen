package com.buaa.classEx;

import java.io.*;

public class Person{
//	private final int ID;
	private String name;
	private String sex;
	private int age;
	
	public Person() {  //构造方法
		super();///////
		System.out.println("父类构造函数");/////
		// TODO Auto-generated constructor stub
	}

	public Person(String n, String s, int a) {///方法重载
		name = n;
		sex = s;
		age = a;
	}

	public void display() {
		System.out.println("姓名：" + name + "," + "性别：" + sex + "," + "年龄：" + age);
	}

	public static void main(String[] args) {
		Person p0=new Person();///
		p0.display();
		Person p = new Person("张三", "男", 20);//////////
		p.display();
		int i=0;///局部变量必须初始化后才能使用
		System.out.println(i);
	}


}

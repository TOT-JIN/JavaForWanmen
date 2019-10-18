package com.buaa.classEx;

public class FinalTest {
	public static void main(String args[]) {

		final double PAI = 3.1415926; // 局部常量

		// final既可以修饰简单数据类型，也可以修饰符和数据类型
		final PersonA p1 = new PersonA("Tom", "M", 23, 001);

		PersonA p2 = new PersonA("Mary", "F", 20, 002);
		System.out.println("final p1:" + p1.toString());

		// p1=p2 //对final对象重新赋值会产生编译错误
		// 以下对final对象中的成员变量，重新赋指是可以的
		p1.name = p2.name;
		p1.sex = p2.sex;
		p1.age = p2.age;
		System.out.println("final p1:" + p1.toString());
	}
}

class PersonA {
	String name;
	String sex;
	int age;
	final static double PAI = 3.1415926; // 静态常量，存放在全局数据区
	final double ID; // 常量，表示每一个人的id不同，但一旦赋值又是不能变化的

	public PersonA(String n, String s, int a, int id) {
		name = n;
		sex = s;
		age = a;
		ID = id; // 构造函数中赋值
	}

	public String toString() {
		String s = "姓名：" + name + "," + "性别：" + sex + "," + "年龄：" + age;
		return s;
	}
}

package com.buaa.staticEx;

public class TestPerson3 {
	public static void main(String[] args) {
		Person p1 = new Person("张三", "男", 20);
		System.out.print("count=" + p1.getCount() + "\t");
		System.out.print("count=" + Person.getCount() + "\n");
		Person p2 = new Person("Tom", "M", 50);
		System.out.print("count=" + p2.getCount() + "\t");
		System.out.print("count=" + Person.getCount() + "\n");
		Person p3 = new Person("Mary", "F", 10);
		System.out.print("count=" + p3.getCount() + "\n");
		System.out.println("通过类名和不同对象名访问静态变量count:");
		System.out.print("count=" + Person.getCount() + "\n");
		System.out.print("count=" + p1.getCount() + "\t");
		System.out.print("count=" + p2.getCount() + "\t");
		System.out.print("count=" + p3.getCount() + "\n");
	}
}

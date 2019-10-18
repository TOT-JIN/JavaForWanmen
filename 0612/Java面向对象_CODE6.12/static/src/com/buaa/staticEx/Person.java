package com.buaa.staticEx;

class Person {
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	String name;//实例变量 heap
	String sex;//实例变量heap
	int age;//实例变量heap
	private static int count;  //类变量  静态数据区 0
	public static int getCount() {  //类方法
		Person p=new Person();
		p.getName();
		getCountAnother();
		return count;
	}
	public static int getCountAnother() {  //类方法
        return count++;
	}
	public Person(String n, String s, int a) {
		name = n;
		sex = s;
		age = a;
		count++;  //////////// 
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {  //实例方法
		String s = "姓名：" + name + "," + "性别：" + sex + "," + "年龄：" + age;
		return s;
	}
	public static void main(String[] args) {
		Person.getCount();//0
		Person p1 = new Person("张三", "男", 20); 
		System.out.print("count=" + p1.getCount() + "\t");//1
		System.out.print("count=" + Person.getCount() + "\n");//1
		Person p2 = new Person("Tom", "M", 50);
		System.out.print("count=" + p2.getCount() + "\t");//2
		System.out.print("count=" + Person.getCount() + "\n");//2
		Person p3 = new Person("Mary", "F", 10);//3
		System.out.print("count=" + p3.getCount() + "\n");//3
		System.out.println("通过类名和不同对象名访问静态变量count:");
		System.out.print("count=" + Person.getCount() + "\n");//
		System.out.print("count=" + p1.getCount() + "\t");//3
		System.out.print("count=" + p2.getCount() + "\t");//3
		System.out.print("count=" + p3.getCount() + "\n");//3
	}
}

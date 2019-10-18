package com.buaa.inheritanceEx;

class Student extends Person {//////
	protected int chinese, math;/////

	public Student() {////
		super();  //通过super()调用弗雷构造函数
		System.out.println("学生类构造函数");//////
	}

	public Student(String name, char sex, int age, int chinese, int math) {
		// super(name,sex,age);
		super.name = name;   //通过super调用父类数据成员
		super.sex = sex;
		super.age = age;

		this.chinese = chinese;
		this.math = math;
	}

	public int average() {
		return (chinese + math) / 2;
	}
	
	public String getDetails() {  //方法覆盖
		return "这个人是："+name+"，平均分是"+average();
	}
}

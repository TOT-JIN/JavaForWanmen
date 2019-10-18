package com.buaa.classEx;

public class TestStudent {
	public static void main(String args[]) {
		
		Student stu1 = new Student("Mary", 'F', "1990.8.8");/////
		System.out.println(stu1.toString());
		stu1.birthday="1990.7.9";
		System.out.println(stu1.toString());
		stu1.setCompScore(98);
		stu1.setEngScore(82);
		System.out.println("计算机成绩：" + stu1.getCompScore());
		System.out.println("英语成绩：" + stu1.getEngScore());
		System.out.println("平均成绩：" + stu1.getAverScore());
		System.out.println("单科最高分：" + stu1.getMaxScore());
	}
}


package com.buaa.classEx;

public class GlobalVar {
	private int a = 10; // 全局变量

	private double b = 20; // 全局变量

	public void print() {
		System.out.println("在print()中, 全局变量　a = " + a + ", b = " + b);
		a = 30;
		System.out.println("在print()中, 全局变量　a = " + a + ", b = " + b);
	}
	
	public static void main(String[] args) {
		GlobalVar globalVar = new GlobalVar();
		System.out.println("全局变量  a = " + globalVar.a);
		// System.out.println("全局变量 a = " +a); 错误写法
		globalVar.print();
		System.out.println("全局变量变化后 a=" + globalVar.a);
	}

}
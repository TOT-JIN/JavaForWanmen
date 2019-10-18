package com.buaa.staticEx;

public class staticBlock {////
	// 定义一个普通的main()方法
	private static int counter;////////
	private int number;
	static {
		System.out.println("This is static block.");
		counter = 0; //这是一个静态全局变量
		int ID=100;// 这是一个局部变量，只在本块内有效
	}
	public static void main(String args[]) {
		System.out.println("This is main method.");
		System.out.println("counter="+counter);
		staticBlock test=new staticBlock();
		System.out.println("counter="+test.number);
	}

	// 定义一个静态代码块

}


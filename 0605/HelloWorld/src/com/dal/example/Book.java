package com.dal.example;

import java.awt.*;

public class Book {
	// 此处 static 指定PAI为全局常量，隶属于整个 Book 类。
	final static double PAI=3.1415926;
	// private 指定 BookID 为局部常量，隶属于某本书，此处赋值仅为初始值，并非全局一致，可一次覆盖。
	private	final int BookID=1001;
	// 未设初值，string 类型为null，int 类型为0。
	private String bookName;
	private int i;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=90;
        String str="string buffer";
		System.out.println(str);
		System.out.println(i);
	}

}

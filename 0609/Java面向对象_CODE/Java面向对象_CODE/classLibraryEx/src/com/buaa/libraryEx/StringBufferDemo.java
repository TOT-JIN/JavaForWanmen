package com.buaa.libraryEx;

public class StringBufferDemo {
	public static void main(String[] args) {
		String s = new String("This is A String");
		StringBuffer sb = new StringBuffer(s); //如何使用String对象构建StringBuffer对象
		sb.deleteCharAt(8); //删除字母A  //索引从0开始
		sb.insert(8, 'a'); //插入一个字符
		int ver = 2;
		sb.insert(sb.length(), "BufferDemo") //插入一个字符串
				.insert(sb.length(), ver); //插入一个整型数
		System.out.println(sb.toString());  //This is a StringBufferDemo2
	}
}

package com.buaa.classEx;

public class StringBufferDemo {
	public static void main(String[] args) {
		String s = new String("This is A String");
		StringBuffer sb = new StringBuffer(s);
		sb.replace(8, 16, "a StringBuffer");
		sb.append("Demo.");
		System.out.println(sb.toString());
		int len = sb.length();
		sb.reverse().append('\n').append("the length of sb = ").append(len)
				.append(',').append(true).append('!');
		System.out.println(sb.toString());
	}
}

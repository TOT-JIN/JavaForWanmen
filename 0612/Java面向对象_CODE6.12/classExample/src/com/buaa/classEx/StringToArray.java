package com.buaa.classEx;

public class StringToArray {
	public static void main(String[] args) {
		String s = "ABCDE";
		byte b[] = s.getBytes();
		System.out.println("\t" + s);
		for (int i = 0; i < b.length; i++)
			System.out.print("\t" + b[i]);
		System.out.println();
		char ch0[] = s.toCharArray();
		myPrint(ch0);
		char ch1[] = new char[3];
		s.getChars(1, 4, ch1, 0);
		myPrint(ch1);
	}

	static void myPrint(char[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print("\t" + obj[i]);
		System.out.println();
	}
}

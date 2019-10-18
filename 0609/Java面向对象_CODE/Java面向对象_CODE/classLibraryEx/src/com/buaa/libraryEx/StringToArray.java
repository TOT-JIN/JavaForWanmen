package com.buaa.libraryEx;

public class StringToArray {
	public static void main(String[] args) {
		String s = "ABCDE";
		
		//如何把字符串转换为字节数组
		byte b[] = s.getBytes();
		System.out.println("\t" + s);  //ABCDE
		for (int i = 0; i < b.length; i++)
			System.out.print("\t" + b[i]);    // 	65	66	67	68	69
		System.out.println();
		
		//如何把字符串转换为字符数组		
		char ch0[] = s.toCharArray();
		myPrint(ch0);                       //	A	B	C	D	E
		
		char ch1[] = new char[3];
		s.getChars(1, 4, ch1, 0);
		myPrint(ch1);                       //	B	C	D
	}

	static void myPrint(char[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print("\t" + obj[i]);
		System.out.println();
	}
}
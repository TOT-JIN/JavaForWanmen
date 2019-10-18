package com.buaa.classEx;

class StringTest2 {
	public static void main(String args[]) {
		String s1 = "This is the second string.";
		String s2 = "This is the second string.";
		String s3 = new String("This is the second string.");
		String s4 = new String(s1);
		String s5 = s1;
		boolean result121 = s1.equals(s2);
		boolean result122 = s1 == s2;
		boolean result131 = s1.equals(s3);
		boolean result132 = s1 == s3;
		boolean result141 = s1.equals(s4);
		boolean result142 = s1 == s4;
		boolean result151 = s1.equals(s5);
		boolean result152 = s1 == s5;
		System.out.println("s1 equals s2= " + result121);
		System.out.println("s1 == s2= " + result122);
		System.out.println("s1 equals s3= " + result131);
		System.out.println("s1 == s3= " + result132);
		System.out.println("s1 equals s4= " + result141);
		System.out.println("s1 == s4= " + result142);
		System.out.println("s1 equals s5= " + result151);
		System.out.println("s1 == s5= " + result152);
	}
}

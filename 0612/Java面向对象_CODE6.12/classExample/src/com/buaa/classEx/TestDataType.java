package com.buaa.classEx;

public class TestDataType {
	public static void main(String[] args) {
		Integer intValue = new Integer("123");
		System.out.println("intvalue 的整数值是：" + intValue);
		
		byte byteValue = intValue.byteValue();
		System.out.println("intvalue 的byte值是：" + byteValue);
		
		double doubleValue = intValue.doubleValue();
		System.out.println("intvalue 的double值是：" + doubleValue);
		
		// 将Integer对象转化为String
		String str = intValue.toString();
		System.out.println("intValue的String值是：" + str);
		
		long longValue = Integer.valueOf(str).longValue();
		System.out.println("longValue 的值是：" + longValue);
	}
}

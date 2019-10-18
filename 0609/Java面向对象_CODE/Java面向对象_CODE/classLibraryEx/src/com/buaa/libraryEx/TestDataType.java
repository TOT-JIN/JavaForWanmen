package com.buaa.libraryEx;


/*
 * 如果需要完成一些基本数据类型量的变换和操作，比如要把一个字符串转化为整数或浮点数，
 * 或者反过来要将一个数字转换成字符串，就需要使用数据类型类的相应方法。
 */
public class TestDataType {
	public static void main(String[] args) {
		Integer intValue = new Integer("123");
		System.out.println("intvalue 的整数值是：" + intValue);
		byte byteValue = intValue.byteValue();
		System.out.println("intvalue 的byte值是：" + byteValue);
		double doubleValue = intValue.doubleValue();
		System.out.println("intvalue 的double值是：" + doubleValue);
		String str = intValue.toString(); // 将Integer对象转化为String
		System.out.println("intValue的String值是：" + str);
		long longValue = Integer.valueOf(str).longValue();
		System.out.println("longValue 的值是：" + longValue);
	}
}
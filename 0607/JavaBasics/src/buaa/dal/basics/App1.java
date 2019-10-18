package buaa.dal.basics;

import java.util.*;

public class App1 {
	public static void main(String args[]) {
	    // 简单数据类型:
		// 定义整形变量a和双精度浮点变量b、c
		int a = 126;
		double b = 0.2;
		double c = 1.6;
		// 复合数据类型（类类型、复杂数据类型）:
		// 创建字符串对象
		// 可以像简单数据类型一样赋值
		String str1 = "Hello World";
		// 也可以用 类 构造函数() 一样创建
		String str = new String("字符串不是基本数据类型");
		// 输出各个变量
		System.out.println("a=" + a);
		System.out.println("b+c=" + (b + c));
		System.out.println("b+c=" + b + c);
		System.out.println(str);
		System.out.println(str1);
	}
}
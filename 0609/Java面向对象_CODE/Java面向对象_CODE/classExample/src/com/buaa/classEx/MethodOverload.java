package com.buaa.classEx;

public class MethodOverload {
	public static void main(String args[]) {
		int a = 51, b = -98, c = 8, d = 191;
		double u = 25.1, v = -29.8, x = 3.1, y = 89.98;
		System.out.println("51、-98、8、191四数的最大值是：" + max(a, b, c, d));
		System.out.println("25.1、-29.8、3.1、89.98四数的最大值是：" + max(u, v, x, y));
	}

	static int max(int a, int b, int c, int d) {
		int x, y;
		x = a > b ? a : b;
		y = c > d ? c : d;
		return x > y ? x : y;
	}

	static double max(double a, double b, double c, double d) {
		double x, y;
		x = a > b ? a : b;
		y = c > d ? c : d;
		return x > y ? x : y;
	}
	/*
	 * 如果一个类中有两个同名方法，其参数列表完全一样，仅仅返回值类型不同，则编译时会产生错误
	 */
	/*	
		static double max(int a, int b, int c, int d) {
			int x, y;
			x = a > b ? a : b;
			y = c > d ? c : d;
			return x > y ? x : y;
		}
	*/
}
package com.buaa.libraryEx;


/*
 * 1、Math类中封装了数学计算中常用的一些数学常量和数学方法，是用于标准数学计算的类；
 * 2、Java中，将Math类定义为final类，不能再派生子类；
 * 3、Math类中定义的常量和方法都用static修饰符来修饰，因此不必创建Math类的实例，
 *    可以通过类名直接使用。
 */
public class MathTest {
	static int arr[] = new int[10];

	public static void main(String[] s) {

		System.out.println("sin(π/4) is " + Math.sin(Math.PI / 4.0));
		System.out.println("2的4次方是 " + Math.pow(2, 4));
		System.out.println("以e为底的e的对数是 " + Math.log(Math.E));
		System.out.println("81的平方根是 " + Math.sqrt(81));
		System.out.println(arr[12]);
	}
}

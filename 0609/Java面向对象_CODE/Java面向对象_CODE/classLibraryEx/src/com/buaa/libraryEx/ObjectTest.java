package com.buaa.libraryEx;

//Object中的equals()方法对比两个对象的引用是否相同，也就是内存中是否是同一个对象
class A {
	public String toString() {
		return "A is for ObjectTest class";
	}
}
public class ObjectTest {
	public static void main(String[] s) {
		A a1 = new A();
		A a2 = new A();
		A a3 = a1;//指向同一个对象
		System.out.println("a1.equals(a1) is " + a1.equals(a1));
		System.out.println("a1.equals(a2) is " + a1.equals(a2));
		System.out.println("a1.equals(a3) is " + a1.equals(a3));
		System.out.println("a1==a1 is " + (a1==a1));
		System.out.println("a1==a2 is " + (a1==a2));
		System.out.println("a1==a3 is " + (a1==a3));
		System.out.println(a1.toString());
		System.out.println("a1 is a instance of class "
				+ a1.getClass().getName());
	}
}

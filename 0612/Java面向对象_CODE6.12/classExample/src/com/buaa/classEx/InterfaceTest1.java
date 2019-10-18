package com.buaa.classEx;

interface A {
	char a = 'A';

	void showa();
}

interface B extends A {
	char b = 'B';

	void showb();
}

interface C {
	char c = 'C';

	void showc();
}

interface D extends B, C {
	char d = 'D';

	void showd();
}

class E implements D {
	char e = 'E';

	public void showa() {
		System.out.println("这里是接口" + a);
	}

	public void showb() {
		System.out.println("这里是接口" + b);
	}

	public void showc() {
		System.out.println("这里是接口" + c);
	}

	public void showd() {
		System.out.println("这里是接口" + d);
	}

	public void showe() {
		System.out.println("这里是类" + e);
	}
}

class InterfaceTest1 {
	public static void main(String args[]) {
		E e = new E();
		e.showa();
		e.showb();
		e.showc();
		e.showd();
		e.showe();
	}
}
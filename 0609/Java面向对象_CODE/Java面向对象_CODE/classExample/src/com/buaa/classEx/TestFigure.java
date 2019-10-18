package com.buaa.classEx;

abstract class Figure {  //抽象类,一般作为其它类的超类
	protected double x;

	Figure() {
	}

	Figure(double x1) {
		x = x1;
	}

	abstract public double area();  //抽象方法

	public String toString() {
		return "x=" + x;
	}
}

class Circle extends Figure {
	public Circle(double x1) {
		super(x1);
	}

	public double area() { //具体方法
		return 3.1415926 * x * x;
	}

	public String toString() {  //方法覆盖
		return "圆：\t" + super.toString() + "\tarea=" + area();
	}
}

class Rectangle extends Figure {
	protected double y;

	public Rectangle() {
	};

	public Rectangle(double a, double b) {
		super(a);
		y = b;
	}

	public double area() {  //具体方法
		return x * y;
	}

	public String toString() {//方法覆盖
		return "长方形：\t" + super.toString() + "y=" + y + "\tarea=" + area();
	}
}

public class TestFigure {
	public static void main(String args[]) {
		Rectangle R1 = new Rectangle(10.0, 20.0);
		Circle C1 = new Circle(10.0);
		Figure F1 = new Rectangle(30.0, 30.0); ///////
		System.out.println(R1.toString());
		System.out.println(C1.toString());
		System.out.println(F1.toString());  /////////
	}
}

package com.buaa.classEx;


class Sup {
	public int x, y;

	Sup(int a, int b) {
		x = a;
		y = b;
	}

	public void display() {
		int z;
		z = x + y;
		System.out.println("add=" + z);
	}
}

class Sub extends Sup {
	Sub(int a, int b) {
		super(a, b);
	}

	public void display() {
		int z;
		z = x * y;
		System.out.println("product=" + z);
	}
}

//diaplay()在编译时不能被系统识别，而是在运行时才被系统识别，也称为运行时多态，也称为动态联编，也称为动绑定。 
public class ResultDemo extends Sub
{   ResultDemo(int x,int y)
    {   super(x,y);
    }
    public static void main(String args[ ])
    {   Sup num1=new Sup(7,14);
        Sub num2=new Sub(7,14);
        ResultDemo num3=new ResultDemo(7,14);
        num1.display( );
        num2.display( );
        num3.display( );
		num1=num2;
		num1.display();
		num1=num3;
		num1.display();
    }
}


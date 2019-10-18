package com.buaa.classEx;

class ASuper {
	String s = "class:A";
}

class BSub extends ASuper {  //继承关系
	String s = "class:B"; //变量隐藏
}

public class TypeV {
	public static void main(String args[]) {
		BSub b1,b3;
		
		ASuper a1, a2, a3;

		BSub b2 = new BSub();
		a1 = b2;  //向上映射，自动转换
		a2 = b2;  //向上映射，自动转换
		System.out.println(a1.s);
		System.out.println(a2.s);
		b1 = (BSub) a1;  //向下映射，强制转换
		System.out.println(b1.s);
		
		a3=new ASuper();
		
	//	b3=(BSub)a3;
		
		if(a3 instanceof BSub)
			b3=(BSub)a3;
		else
			System.out.println("can not be transfered!");
	}
}




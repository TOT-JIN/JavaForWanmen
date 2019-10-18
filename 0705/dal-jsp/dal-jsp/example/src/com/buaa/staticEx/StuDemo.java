package com.buaa.staticEx;

class Student {
	static int num;  //类变量，保存在全局数据区，所有的对象共享0  1 2 3 4
	int number;     //实例变量，保存在heap，每个对象有一份独立的拷贝0
	int add1() {//add1()方法退出时，内存中的值可以保留
		num = num + 1;  
		return num;
	}
	int add2() {  //add2()方法退出时，内存中的值不能保留
		number = number + 1;//1  1  1
		return number;
	}
}
public class StuDemo
{
    public static void main(String args[ ])
    {
    	
    	System.out.println(Student.num);////
    	//System.out.println(Student.number);////
        Student zhang=new Student( );
        Student wang=new Student( );
        Student jiang=new Student( );
        System.out.println(zhang.num);////
        System.out.println(wang.num);////
        System.out.println(jiang.num);////
        
        System.out.println("zhang.num="+zhang.add1( ));//1
        System.out.println("zhang.number="+zhang.add2( ));//1
        System.out.println("wang.num="+wang.add1( ));//2
        System.out.println("wang.number="+wang.add2( ));//1
        System.out.println("jiang.num="+jiang.add1( ));//3
        System.out.println("jiang.num="+jiang.add1( ));
        System.out.println("zhang.num="+zhang.add1( ));
        System.out.println("jiang.num="+jiang.add1( ));
        System.out.println("jiang.number="+jiang.add2( ));//1
    }
}
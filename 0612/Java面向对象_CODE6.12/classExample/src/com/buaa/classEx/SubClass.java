package com.buaa.classEx;

class SuperClass
{
	int b;
	public SuperClass(){}  ///////////////////
	public SuperClass(int i){
		b=i;
	}
}

/*如果类中提供的构造函数都不是无参数构造函数，却企图调用无参数构造函数初始化此类的对象，编译时会产生语法错误*/
public class SubClass extends SuperClass{
	double c=7.8;
	public static void main(String[] args){}
}

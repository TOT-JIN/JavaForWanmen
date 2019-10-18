package com.buaa.classEx;

/*
 public class Singleton {
 // 静态的。保留自身的引用。
 private static Singleton test = new Singleton();

 // 必须是私有的构造函数
 private Singleton() {
 }

 // 公共的静态的方法。
 public static Singleton getInstance() {
 return test;
 }
 }
 */

public class Singleton {//静态的。保留自身的引用。
	private static Singleton test = null;
    private int size=512;
	//必须是私有的构造函数
	private Singleton() {
	}

	//公共的静态的方法。
	public static Singleton getInstance() {
		if (test == null) {
			test = new Singleton();
		}
		return test;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public static void main(String[] args){
		Singleton[] singleInstance=new Singleton[10];

		for(int i=0;i<10;i++){
			singleInstance[i]=Singleton.getInstance();
			System.out.println(singleInstance[i].getSize());
		}
		singleInstance[0].setSize(1024);
		for(int i=0;i<10;i++){
			System.out.println(singleInstance[i].getSize());
		}
	}


}

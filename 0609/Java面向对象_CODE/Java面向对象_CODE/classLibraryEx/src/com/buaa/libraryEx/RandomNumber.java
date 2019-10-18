package com.buaa.libraryEx;

import java.util.Random;


/*
 * public Random(); //构造函数
 * public void nextBytes(byte[] bytes); //生成随机数据的字节数组，存放在byte[]；
 * public int nextInt();  //范围[0~n）整数
 * public long nextLong(); //long范围随机数
 * public float nextFloat();  //范围为[0.0f~1.0f)
 * public double nextDouble();  //范围为[0.0d~1.0d)
 */
public class RandomNumber {
	public static void main(String[] args) {
		Random rand1 = new Random();
		byte[] b = new byte[5];
		rand1.nextBytes(b);  //产生5个随机的字节数据
		for (int i = 0; i < 5; i++)
			System.out.print(b[i] + "\t");
		
		System.out.println();
		
		for (int i = 0; i < 5; i++)
			System.out.print(rand1.nextInt(100) + "\t");  //产生5个随机的整数
		
		System.out.println();
		
		for (int i = 0; i < 3; i++)
			System.out.print(rand1.nextDouble() + "\t");  //产生5个随机的双精度浮点数
		System.out.println();
	}
}
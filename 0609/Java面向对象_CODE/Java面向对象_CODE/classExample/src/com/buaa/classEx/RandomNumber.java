package com.buaa.classEx;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random rand1 = new Random();
		byte[] b = new byte[5];
		rand1.nextBytes(b);
		for (int i = 0; i < 5; i++)
			System.out.print(b[i] + "\t");
		System.out.println();
		for (int i = 0; i < 5; i++)
			System.out.print(rand1.nextInt(100) + "\t");
		System.out.println();
		for (int i = 0; i < 3; i++)
			System.out.print(rand1.nextDouble() + "\t");
		System.out.println();
	}
}

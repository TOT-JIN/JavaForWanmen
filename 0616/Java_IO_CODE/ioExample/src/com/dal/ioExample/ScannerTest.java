package com.dal.ioExample;
import java.util.Scanner;
public class ScannerTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);////
		System.out.println("请输入字符串：");//从键盘读入字符串
		while (true) {
			String line = s.nextLine();
			if (line.equals("exit"))
				break;
			System.out.println(">>>" + line);
		}
		while (true) {   //从键盘读入整数
			int line = s.nextInt();
			if (line==0)
				break;
			System.out.println(">>>" + line);
		}
		while (true) {   //double
			double line = s.nextDouble();
			if (line==0.0)
				break;
			System.out.println(">>>" + line);
		}	
		s.close();
	}
}

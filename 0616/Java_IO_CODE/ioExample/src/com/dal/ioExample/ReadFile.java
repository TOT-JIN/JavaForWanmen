package com.dal.ioExample;

import java.io.*;

public class ReadFile {
	public static void main(String args[]) {
		File file = new File(
				"F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\test.txt");
		FileInputStream fis;
		int n = 0;
		byte b[] = new byte[8];
		try {
			fis = new FileInputStream(file);
			System.out.println("支持做标记？" + fis.markSupported());
			// 读取文件中前5个子节并存放到数组b中（下标3开始）
			n = fis.read(b, 3, 5);
			fis.close();// 关闭流
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		System.out.println("实际读取的字节数：" + n);
		for (int i = 0; i < b.length; i++) { // 输出子节数组中的数据
			System.out.print(b[i] + "  ");
		}
		System.out.println();
		for (int i = 3; i < b.length; i++) { // 输出子节数组中从下标3开始的数据
			System.out.print((char) b[i] + "  ");
		}
		System.out.println();
	}
}

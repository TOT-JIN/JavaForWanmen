package com.dal.ioExample;

import java.io.*;
public class WriteFile{
	public static void main(String[] args){
		FileOutputStream file;
		byte[] buffer=new byte[1028];
		System.out.println("请输入数据，回车后保存到文件test.txt.");
		System.out.println("输入'#'则退出.");
		try{
			file=new FileOutputStream("F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\test.txt",true);
			while(true){
				int n=System.in.read(buffer);
				if(buffer[0]=='#')
					break;
				file.write(buffer,0,n);
				file.write('\n');	
			}
			file.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.toString());	
		}
		catch(IOException e){
			System.out.println(e.toString());	
		}
	}
}

			

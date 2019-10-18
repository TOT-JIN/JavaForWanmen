package com.dal.ioExample;

//read an entire file with FileInputStream

import java.io.*;
import java.util.Date;

public class J_FileInputStream{
	public static void main(String[] args){
		InputStream f;
        int ch;
		long i=0;
		System.out.println("Start!");
		Date d1=new Date();
		
		try{
			f=new FileInputStream("F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\test.txt");
			while((ch=f.read())!=-1)
				i++;
			f.close();	
		}	
		catch(Exception e){
				System.out.println(e);
				System.exit(-1);
		}
		Date d2=new Date();
		long elapsedTime=d2.getTime()-d1.getTime();
		System.out.println("Stop!");
		System.out.println("Read a"+i+"-byte file");
		System.out.println("using" + elapsedTime+"Milliseconds(0.001 Seconds).");
	}		
}
package com.dal.ioExample;

import java.io.*;
public class TestDataStream{
	public static void main(String[] args){
		try{
			byte[] b0={48,49,50,51,52};
			//写数据到文件"demo.txt";
			FileOutputStream fos=new FileOutputStream("F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\demo.txt");
			DataOutputStream dos=new DataOutputStream(fos);
			dos.write(b0,0,b0.length);//将字节数组b0的数据输出到缓冲区
			dos.writeBoolean(true);
			dos.writeDouble(1.23);
			dos.writeUTF("java程序设计");
			System.out.println("已写入缓冲区的字节数："+dos.size());
			dos.flush();//清空缓冲区
			//读文件"demo.txt"中的数据
			FileInputStream fis=new FileInputStream("F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\demo.txt");
			BufferedInputStream bis=new BufferedInputStream(fis);
			DataInputStream dis=new DataInputStream(bis);
			System.out.println("available："+dis.available());
			System.out.println("markSupported："+dis.markSupported());
			dis.skip(5);//跳过5个字节后，读取的是boolean型数据
			System.out.println("跳过5个字节后读取数据并显示，结果如下：");
			System.out.println("    "+dis.readBoolean());
			System.out.println("    "+dis.readDouble());
			dis.mark(1);//在当前读取位置做标记
			System.out.print("   "+dis.readUTF());//显示Java程序设计
			dis.reset();//重设读取位置到标记位置
			System.out.print("   "+dis.readUTF()); //显示Java程序设计
		}
		catch(IOException e){System.out.println(e);}
    }
}
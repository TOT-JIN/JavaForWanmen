package com.dal.ioExample;

/*
 *Display the contents of the "test.txt",
 *and calculate its length using FileInputStream
 **/

import java.io.*;

public class J_Example{
	public static void main(String[] args){
		int i;
		int b;
		try{
			FileInputStream f=new FileInputStream("F:\\BaiduYunDownload\\eclipse-jee-kepler-SR1-win32-x86_64\\eclipse\\workspace\\ioExample\\src\\com\\dal\\ioExample\\test.txt");
			b=f.read();
			for(i=0;b!=-1;i++){
				System.out.print((char)b);
				b=f.read();	
			}
			System.out.println();
			System.out.println("TOTAL="+i);
			f.close();	
		}	
		catch(Exception e){
			System.out.println(e);	
		}
	}	
}

/*
import java.io.*;
public class DataTest {
public static void main(String［］ args) throws IOException {
FileOutputStream fout=new FileOutputStream(″data.txt″);
DataOutputStream out=new DataOutputStream(fout);
float［］ prices={1.5f,2.1f,2.9f,1.8f,3.1f};
int［］ units={5,2,4,3,1};
String［］ items={″苹果″,″鸭梨″,″蜜桃″,″橙子″,″葡萄″};
for (int i=0; i<prices.length; i++) {
out.writeFloat(prices［i］);
out.writeChar(′＼t′);
out.writeInt(units［i］);
out.writeChar(′＼t′);
out.writeChars(items［i］);
out.writeChar(′＼n′);
}
out.close( );
fout.close( );
FileInputStream fin=new FileInputStream(″data.txt″);
DataInputStream in=new DataInputStream(fin);
float price,total=0.0f;
int unit;
char ch;
String item;

try {
while (true) {
price=in.readFloat( );
in.readChar( );// 跳过Tab
unit=in.readInt( );
in.skip(2);// 跳过Tab
item=new String( );// 清空字符串
while((ch=in.readChar( ))!=′＼n′)// 每次读一个字符，碰到换行符结束
item+=ch;// 将字符合成字符串
System.out.println(″你买了″+unit+″斤″+item+″ 单价是″+price);
total+=unit*price;
}
} catch (EOFException e) {}// 读到文件尾将抛出异常并终止循环
in.close( );
fin.close( );
System.out.println(″你总共花去″+total+″元″);
}
}
程序采用了一个条件恒为真的循环读取整个文件内容，那么怎样才能退出循环呢？显然不能用读取某个数据为退出条件，前面例子中有读取一个-1时结束循环的用法，这个方法在此处无效，因为文件中的数据很可能就包含-1。但文件内容读完后再试图读取，系统就会抛出一个EOFException异常，我们就用它来结束循环。
*/
package buaa.com.exceptionEx;

import java.io.*;

//如果最终方法也没有处理异常，异常将交给系统处理。
public class ThrowsTest5E {
	public static void main(String args[]) {
		FileInputStream in;
		try {
			in = new FileInputStream("myfile.txt");
			int b;
			b = in.read();
			while (b != -1) {
				System.out.print((char) b);
				b = in.read();
				
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		} finally {
				System.out.println(" It’s ok!");
		}
	}

}

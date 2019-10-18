package buaa.com.exceptionEx;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest5 {
	public static void main(String args[]) throws IOException 
	{
		FileInputStream in = new FileInputStream("myfile.txt");
			int b;
			b = in.read();
			while (b != -1) {
				System.out.print((char) b);
				b = in.read();
			}
			in.close();
	}
}
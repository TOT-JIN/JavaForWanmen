package buaa.edu.com;

import java.io.*;
public class F {
	 public static void main(String args[]) {
	      int n=-1;
	      File f =new File("hello.txt");
	      byte [] a="abcd".getBytes();
	      try{ FileOutputStream out=new FileOutputStream(f);
	          out.write(a);
	          out.close(); 
	          FileInputStream in=new FileInputStream(f);
	          byte [] tom= new byte[3];
	          int m = in.read(tom,0,3);
	          System.out.println(m);       //【代码1】
	          String s=new String(tom,0,3);
	          System.out.println(s);        //【代码2】
	          m = in.read(tom,0,3);
	          System.out.println(m);       //【代码3】
	          s=new String(tom,0,3);
	          System.out.println(s);        //【代码4】
	      }
	      catch(IOException e) {}
}}
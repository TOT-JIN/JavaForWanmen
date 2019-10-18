package com.dal.ioExample;
import java.io.*;
public class KeyboardInput {

	public static void main(String[] args) {
		String s;
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(ir);
		System.out.println("In Windows,type ctrl-z to exit;"+"In linux,type ctrl-d to exit;");
		System.out.println();
		try{
			s=in.readLine();
			while(s!=null){
				System.out.println("read: "+s);
				s=in.readLine();
			}
			in.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}

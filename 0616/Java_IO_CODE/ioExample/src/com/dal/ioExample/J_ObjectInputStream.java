package com.dal.ioExample;

import java.io.*;

public class J_ObjectInputStream{
	public static void main(String[] args) throws Exception{
		ObjectInputStream f=new ObjectInputStream(new FileInputStream("object.dat"));
		J_Student s=(J_Student)(f.readObject());
		s.mb_output();
		f.close();
	}	
}

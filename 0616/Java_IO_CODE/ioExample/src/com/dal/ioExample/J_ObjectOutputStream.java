package com.dal.ioExample;

import java.io.*;
/*
class J_Student implements Serializable{
	String m_name;
	int m_id;
	int m_height;
	public void mb_output(){
		System.out.println("Name =" + m_name);
		System.out.println("ID ="+m_id);
		System.out.println("Height ="+m_height);	
	}	
}*/
public class J_ObjectOutputStream{
	public static void main(String[] args)throws Exception{
		ObjectOutputStream f=
          new ObjectOutputStream(new FileOutputStream("object.dat"));
		J_Student s=new J_Student();
		s.m_name="Zhang, San";
		s.m_id=2003001;
		s.m_height=172;
		f.writeObject(s);
		s.mb_output();
		f.close();
			
	}	
}
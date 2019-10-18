package com.dal.ioExample;

import java.io.*;
class J_Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8965262128823892184L;
	String m_name;
	int m_id;
	int m_height;
	public void mb_output(){
		System.out.println("Name =" + m_name);
		System.out.println("ID ="+m_id);
		System.out.println("Height ="+m_height);	
	}	
}

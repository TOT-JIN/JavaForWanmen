package com.buaa.classEx;

class J_Book extends Object{/////
	private String m_name;////

	J_Book(String name) {
		m_name = name;
	}
	protected void finalize() {//¸²¸Ç
		System.out.println("Book,\"" + m_name + "\",is destroyed!");
	}
}
public class J_Finalize {
	public static void main(String args[]) {
		J_Book book1 = new J_Book("Gone with Wind");//////
		new J_Book("Java How To Program"); 
   		new J_Book("Roman Holiday");
		book1 = new J_Book("thinking in Java");    
		System.gc();// drop the reference
	
	}
}
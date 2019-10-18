package com.buaa.classEx;

public class Book extends Object {
	private final int bookId=1000;	
	private String color;
	private int bookName;
	private int bookCom;
/*	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public Book(String color, int bookName, int bookCom) {
		super();
		this.color = color;
		this.bookName = bookName;
		this.bookCom = bookCom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getBookName() {
		return bookName;
	}
	public void setBookName(int bookName) {
		this.bookName = bookName;
	}
	public int getBookCom() {
		return bookCom;
	}
	public void setBookCom(int bookCom) {
		this.bookCom = bookCom;
	}
	public int getBookId() {
		return bookId;
	}
    public static void main(String[] args){
    	Book hello=new Book("piao",10,1000);/////////////
    	System.out.println(hello.toString());
    	System.out.println(hello.getBookCom());
    }

}

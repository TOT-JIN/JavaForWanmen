package com.buaa.classEx;
class Desk {
	private String color;
	private int length;
	private int width;
	private int height;
	public Desk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Desk(String color, int height, int length, int width) {
		super();
		// TODO Auto-generated constructor stub
		this.color = color;
		this.height = height;
		this.length = length;
		this.width = width;
	}
	
	//计算桌子体积的方法
	public int volume() {
		return length * width * height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public static void main(String[] args){
	    //test phrase 1
		Desk desk1=new Desk();/////
		System.out.println("desk1's volume is:"+desk1.volume());		
		desk1.color="red";
		desk1.setColor("red");
		desk1.height=40;
		desk1.setHeight(40);
		desk1.length=20;
		desk1.setLength(20);
		desk1.width=20;
		desk1.setHeight(20);
		System.out.println("desk1's volume is:"+desk1.volume());
	
		//test phrase 2
		Desk desk2=new Desk("red", 30, 30, 30);/////
		System.out.println("desk2's volume is:"+desk2.volume());
	}


}
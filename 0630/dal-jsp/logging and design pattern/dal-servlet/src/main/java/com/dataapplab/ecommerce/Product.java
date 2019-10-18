package com.dataapplab.ecommerce;

public class Product {
    int id;
    String title, detail, thumbnail;
    double price;
    
    public Product(int id, String title, String detail, String thumbnail, double price){
    	this.id = id;
    	this.title = title;
    	this.detail = detail;
    	this.thumbnail = thumbnail;
    	this.price = price;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

	public String getTitle() {
		return this.title;
	}
	
	public String getDetail(){
		return this.detail;
	}
	
	public String getThumbnail(){
		return this.thumbnail;
	}
	
	public double getPrice(){
		return this.price;
	}

	@Override
	public String toString() {
		return "Product [title=" + this.title + "]";
	}
}

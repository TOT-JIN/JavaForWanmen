package com.dataapplab.springboot.domain;

import java.util.Date;

public class BaseModel {
    private int id;
    private Date createDate;
    private Date modifiedDate;
    
    public BaseModel(){
    	this.createDate = new Date();
    	this.modifiedDate = new Date();
    }
    
    public BaseModel(int id){
    	this.id = id;
    	this.createDate = new Date();
    	this.modifiedDate = new Date();
    }
    
	public Integer getId() {
		return id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

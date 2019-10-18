package com.dataapplab.springboot.order;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dataapplab.springboot.domain.BaseModel;


public class PaymentMethod extends BaseModel 
{
	private Integer id;
	private String ccNumber;
	private String cvv;
	private BigDecimal amount;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getCcNumber()
	{
		return ccNumber;
	}
	public void setCcNumber(String ccNumber)
	{
		this.ccNumber = ccNumber;
	}
	public String getCvv()
	{
		return cvv;
	}
	public void setCvv(String cvv)
	{
		this.cvv = cvv;
	}
	public BigDecimal getAmount()
	{
		return amount;
	}
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
		
}
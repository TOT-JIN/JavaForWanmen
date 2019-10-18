package com.dataapplab.springboot.product;

import com.dataapplab.springboot.domain.BaseModel;

public class VariantOptions extends BaseModel{
	private Variant variant;
	private String value;
	private int order;
	
	public Variant getVariant() {
		return variant;
	}

	public String getValue() {
		return value;
	}
	public int getOrder() {
		return order;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}

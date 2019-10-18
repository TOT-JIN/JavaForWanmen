package com.dataapplab.springboot.product;

public class ProductView {
	public interface WithoutPriceView {};
	public interface WithPriceView extends WithoutPriceView {};
}

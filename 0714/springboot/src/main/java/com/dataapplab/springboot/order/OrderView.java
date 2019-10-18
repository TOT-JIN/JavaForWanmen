package com.dataapplab.springboot.order;

import com.dataapplab.springboot.product.ProductView.WithoutPriceView;

public class OrderView {
	public interface CartView {};
	public interface CheckoutView extends CartView {};	
}

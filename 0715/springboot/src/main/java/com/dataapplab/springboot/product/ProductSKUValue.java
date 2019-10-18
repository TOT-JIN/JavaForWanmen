package com.dataapplab.springboot.product;

import com.dataapplab.springboot.domain.BaseModel;

public class ProductSKUValue extends BaseModel{
	private Variant variant;
	private VariantOptions variantOptions;
	private ProductSKU sku;
	private Product product;
	
	public Variant getVariant() {
		return variant;
	}
	public VariantOptions getVariantOptions() {
		return variantOptions;
	}
	public ProductSKU getSku() {
		return sku;
	}
	public Product getProduct() {
		return product;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public void setVariantOptions(VariantOptions variantOptions) {
		this.variantOptions = variantOptions;
	}
	public void setSku(ProductSKU sku) {
		this.sku = sku;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}

package com.dataapplab.springboot.order;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cart")
public class OrderProperties {

    private String cookieName = "ONE-PIECE";

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}


}
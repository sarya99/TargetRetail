package com.target.retailApp.Retail;

public class CurrentPrice {
	private String priceCurrency;
	private String priceValue;

	public String getpriceValue() {
		return priceValue;
	}

	public void setpriceValue(String priceValue) {
		this.priceValue = priceValue;
	}

	public String getpriceCurrency() {
		return priceCurrency;
	}

	public void setpriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	

	public CurrentPrice(String priceCurrency, String priceValue) {
		super();
		this.priceValue = priceValue;
		this.priceCurrency = priceCurrency;
	}
	
}

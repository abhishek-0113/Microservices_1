package com.example;

public class Trade {
	private String ticker;
	private double price;
	private int qty;
	private double totalCost;

	public Trade(String ticker, Double price, int qty) {
		// TODO Auto-generated constructor stub
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Trade [ticker=" + ticker + ", price=" + price + ", qty=" + qty + ", totalCost=" + totalCost + "]";
	}
	
	

}

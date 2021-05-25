package com.example.demo;

public class Products {
	private int id;
	private String title;
	private double price;
	private int stock;
	private String store;
	
	public Products(String title, double price, int stock, String store) {
		this.id = 5;
		this.title = title;
		this.price = price;
		this.stock = stock;
		this.store = store;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	
	public void printOnConsole() {
		System.out.println(this.getId());
		System.out.println(this.getTitle());
		System.out.println(this.getPrice());
		System.out.println(this.getStock());
		System.out.println(this.getStore());
		
		System.out.println("----------------");
	}
}

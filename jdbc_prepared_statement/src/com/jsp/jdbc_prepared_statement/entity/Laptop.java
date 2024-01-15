package com.jsp.jdbc_prepared_statement.entity;
/**
 * @author rahul
 * 
 * 
 * 
 */
public class Laptop {
	private int id;
	private String name;
	private String color;
	private String ram;
	private double price; 
	

	public Laptop(int id, String name, String color, Double price, String ram) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.ram = ram;
		this.price = price;
	}

	public Laptop() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price=price;
	}
	
	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	@Override
	public String toString() {
		return "\n id=" + id + ", \n name=" + name + ", \n color=" + color + ", \n ram=" + ram + ", \n price=" + price +" \n" ;
	}
	

}
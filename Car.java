package org.fsg.map.project;

public class Car {
	private String num;
	private String name;
	private String colour;
	private Double price;
	private String brand;
	private Integer yom;
	
	
	public Car(String num, String name,String colour, Double price, String brand, Integer yom) {
		super();
		this.num = num;
		this.name = name;
		this.colour=colour;
		this.price = price;
		this.brand = brand;
		this.yom = yom;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getYom() {
		return yom;
	}


	public void setYom(Integer yom) {
		this.yom = yom;
	}
	
	
	
	@Override
	public String toString() {
		
		return num+"\t"+name+"\t"+colour+"\t"+price+"\t"+brand+"\t"+yom;
	}

}

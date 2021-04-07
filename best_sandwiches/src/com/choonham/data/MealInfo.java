package com.choonham.data;

public class MealInfo {

	private int rank;
	private String cafe;
	private String menu;
	private float price;
	private String address;
	private String imgName;

	public MealInfo() {
		// TODO Auto-generated constructor stub
	}

	public MealInfo(String rank, String cafe, String menu, String price, String address, String imgName) {
		this.rank = Integer.parseInt(rank);
		this.cafe = cafe;
		this.menu = menu;
		this.price = Float.parseFloat(price);
		this.address = address;
		this.imgName = imgName;
	}

	public int getRank() {
		return rank;
	}

	public String getCafe() {
		return cafe;
	}

	public String getMenu() {
		return menu;
	}

	public float getPrice() {
		return price;
	}

	public String getAddress() {
		return address;
	}

	public String getImgName() {
		return imgName;
	}

}

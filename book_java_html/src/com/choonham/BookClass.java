package com.choonham;

public class BookClass extends PressClass{

	private String title;
	private String image; 
	private int dc;
	private int price;
	
	public BookClass() {
		// TODO Auto-generated constructor stub
	}
	public BookClass(String image, String title, int dc, int price, String press, String author) {
		super(press, author);
		this.image = image;
		this.title = title;
		this.dc = dc;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getDc() {
		return dc;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}

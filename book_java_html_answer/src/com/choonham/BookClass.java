package com.choonham;

public class BookClass extends PressClass{
	// DO it HTML 5 CSS 3__고경희__이지스퍼블리싱__16800__06365234__20
	/** 외부 접근할 수 없도록 제목, 가격, 책표지, 할인율 변수 ㅣ private **/
	private String title;
	private String image; 
	private int discount;
	private int price;
	
	public BookClass() {
	}

	/** 추가 생성자 : 전체 6개의 데이터를 전달 받아 자신과 부모의 변수에 대입 **/
	public BookClass(String title, String author, String press, String price, String image, String discount) {
		super(press, author);
		this.image = image + ".jpg";
		this.title = title;
		this.discount = Integer.parseInt(discount);
		this.price = Integer.parseInt(price);
	}
	/** 외부로부터 데이터를  추출할 수 있도록 private 변수의 getter 들  선언 **/
	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public int getDiscount() {
		return discount;
	}

	public int getPrice() {
		return price;
	}

	/** 객체가 보유하고 있는 값을 쉬게 출력하기 위한 메서드 선언**/
	public void testToString( ) {
		System.out.println(this.title + " : " + super.getAuthor() + " : " + this.price + " : " + super.getPress() + " : " + this.image + " : " + this.discount);
	}

}

package com.choonham;

public class PressClass {
	/** 외부 접근할 수 없도록 저자와 출판사 변수 ㅣ private **/
	
	private String press = "";
	private String author = "";
	
	public PressClass() {
	}

	/** 추가 생성자 **/
	/** 자식 클래스의 생성자로 부터 저자명과 출판사명을 전달 받아 멤버변수에 각각 저장하는 생성자 선언 **/
	public PressClass(String press, String author) {
			this.press = press;
			this.author = author;
	}

	public String getPress() {
		return press;
	}

	public String getAuthor() {
		return author;
	}

	/** 외부로부터 저자명과 출판사명을 추출할 수 있도록 각각의 getter 메서드 선언 **/

}

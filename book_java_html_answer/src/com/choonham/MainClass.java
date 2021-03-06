package com.choonham;

public class MainClass {

	public static void main(String[] args) {

		/** 읽어들일 문서의 경로 및 파일명을 MethodClass의 readBooksData() 메서드에게 전달 **/
		/** 필요에 따라 콘솔로부터 입력받을 수 있도록 수정 가능 **/
		String uri = "c:/filetest/bookdata.txt";
		MethodClass.readBooksData(uri);

		/** MethodClass의 makeBooksHTML() 메서드를 이용하여 HTML 태그 완성 **/
		String tags = MethodClass.makeBooksHTML();

		/** 완성된 태그 확인 : 확인 후, 코드 삭게 **/
		System.out.println(tags);

		/** PrintClass의 makeHTML() 에 태그명과 저장 경로 및 파일명을 전달하여 html 파일 완성 **/
		/** 필요에 따라 콘솔로부터 입력받을 수 있도록 수정 가능 **/
		String url = "c:/filetest/bookList_test.html";
		PrintClass.makeHTML(tags, url);
	}

}

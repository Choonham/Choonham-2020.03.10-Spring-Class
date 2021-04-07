package com.choonham.util;

public interface Methods {
	
	/** Excel File을 읽어와 객체화시키는 메서드 **/
	public void readExcel(String uri);

	
	
	/** Tags를 인자로 받아 HTML파일을 만드는 메서드 **/
	public void makeHTML(String uri, String tags);
}

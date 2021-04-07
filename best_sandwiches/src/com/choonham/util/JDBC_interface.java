package com.choonham.util;

public interface JDBC_interface {
	/** 객체화된 DATA를 DB에 넣는 메서드 **/
	public void putDataInto();

	/** DB에 있는 DATA를 꺼내와 HTML Tags를 만드는 메서드 **/
	public String makeTags();
	
	/** DB에 이미 데이터가 들어가 있는 상태인지 확인하기 위한 메서드**/
	public int countDB();
}

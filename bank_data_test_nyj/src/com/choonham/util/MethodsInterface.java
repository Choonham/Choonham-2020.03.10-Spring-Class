package com.choonham.util;

import java.util.ArrayList;

public interface MethodsInterface {

	
	//검색 조건을 받아 검색하여 ArrayList에 저장하는 메서드(ArrayList를 반환함, ExcelWriter에서 사용하기 위해)
	public void searchStart(); 
	public void getSearchResult(ArrayList<String> searchCondition, ArrayList<String> searchInput);
	//tags 를 생성하는 메서드
	public String makeTags();
}

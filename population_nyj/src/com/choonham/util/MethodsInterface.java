package com.choonham.util;

import java.util.ArrayList;

public interface MethodsInterface {
	//To read an excel data file
	public void excelReader(String uri);
	
	
	//To get a most populous town(foreigners)
	public String getMostPopulous_Foreigner();
	//To get towns that live more koreans than foreigner
	public ArrayList<String> getKoreanTown();
	
	//To find a good place to live for the old man
	public String findThePlace(); 
	
	//To make HTML tags
	public String makeTags(String ans1, ArrayList<String> ans2, String ans3);
	
	//To write an HTML file
	public void makeHTML(String tags, String uri);
}

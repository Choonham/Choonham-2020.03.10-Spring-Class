package com.choonham;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MethodClass {
	
	public MethodClass() {
	}
	
	public static  ArrayList<String> readBookData(String uri) throws IOException {
		ArrayList<String> totalData = new ArrayList<String>();
		File file = new File( uri);
		BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
		String line = "";
		while((line=br.readLine()) != null) {
			totalData.add(line);
		}
		return totalData;
	}
	
	public static String makeBooksHTML(String image, String title, String author, String press, int price, int dc) {
		String tags = "";
		tags = "<tr>" + 
		"<td>" + "<img src=\'c:/filetest/bookImages/" + image + ".jpg\'>" + "</td>"+ 
		"<td>" + title + "</td>"+ 
		"<td>" + author + "</td>"+ 
		"<td>" + press + "</td>"+ 
		"<td>" + price + "</td>"+ 
		"<td>" + dc + "</td>"+ 
		"</tr>"; 
		return tags;
	}
	

}

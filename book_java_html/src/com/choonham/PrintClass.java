package com.choonham;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintClass {

	public PrintClass(){
		
	}
	
	public static void printProcess() throws IOException {
		ArrayList<String> printList = new ArrayList<>();
		DataClass dc = new DataClass(MethodClass.readBookData("c:/filetest/bookdata.txt"));
		String uri="c:/filetest/book_list_html.html";
		FileWriter fw =new FileWriter(uri);
		BufferedWriter  bw =new BufferedWriter(fw);
		
		for(int i = 0; i < dc.bcArray.size(); i++) {
			printList.add(MethodClass.makeBooksHTML(dc.bcArray.get(i).getImage(), dc.bcArray.get(i).getTitle(), dc.bcArray.get(i).getAuthor(), 
					dc.bcArray.get(i).getPress(), dc.bcArray.get(i).getPrice(), dc.bcArray.get(i).getDc()));
		}
		String initTags = "<!doctype>\r\n" + 
				"\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"<head><title>News Stand</title></head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"		\r\n" + 
				"\r\n" + 
				"<table border='1'>\r\n" + 
				"\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td>책표지</td>\r\n" + 
				"\r\n" + 
				"<td>제목</td>\r\n" + 
				"\r\n" + 
				"<td>저자</td>\r\n" + 
				"\r\n" + 
				"<td>출판사</td>\r\n" + 
				"\r\n" + 
				"<td>정가</td>\r\n" + 
				"\r\n" + 
				"<td>할인율</td>\r\n" + 
				"\r\n" + 
				"</tr>";
		String endTags = "</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html> ";
		bw.write(initTags);
		for(int i = 0; i < printList.size(); i++) {
			bw.write(printList.get(i));
		}
		bw.write(endTags);
		bw.close();
		fw.close();
	}

}

package com.choonham;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodClass {
	private static DataClass dc = null;

	public MethodClass() {
	}

	/** MainClass의 main() 내부로 부터 읽어들일 파일의 경로와 이름을 전달 받아 **/ 
	/** DataClass 의 멤버(ArrayList) 에 추가  **/
	public static void readBooksData(String uri) {
		FileReader fr = null;
		BufferedReader br = null;
		BookClass o = null;
		
		String one = "";
		String[] temp = null;
		
		try {
			File file = new File(uri);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
			while((one = br.readLine()) != null) {
				temp = one.split("__");
				o = new BookClass(temp[0],  temp[1], temp[2], temp[3], temp[4], temp[5]);
				o.testToString();
				DataClass.books.add(o);
			}
			br.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // readBooksData() END

	/** DataClass 의 멤버(ArrayList) 에 추가된 데이터를 이용하여**/
	/**  실제 html 파일의  내부 태그들을 완성 **/
	public static String makeBooksHTML() {
		int rowCount  = DataClass.books.size();
		String tags = "";
		tags = tags + "<!doctype>";
		tags = tags + "<html>";
		tags = tags + "<head><title>News Stand</title></head>";
		tags = tags + "<body>";
		tags = tags + "<table border='1'>";
		tags = tags + "<tr>";
		tags = tags + "<td>책표지</td>";
		tags = tags + "<td>제목</td>";
		tags = tags + "<td>저자</td>";
		tags = tags + "<td>출판사</td>";
		tags = tags + "<td>정가</td>";
		tags = tags + "<td>할인율</td>";
		tags = tags + "</tr>";

		for(int i = 0; i < rowCount; i++) {
			tags = tags + "<tr>"; // 행 시작

			tags = tags + "<td>"; // 열 시작
			tags = tags + "<img src='./bookImages/" + DataClass.books.get(i).getImage() + "' />";
			tags = tags + "</td>"; // 열 닫기
			
			tags = tags + "<td>"; // 열 시작
			tags = tags + DataClass.books.get(i).getTitle();
			tags = tags + "</td>"; // 열 닫기
			
			tags = tags + "<td>"; // 열 시작
			tags = tags + DataClass.books.get(i).getAuthor();
			tags = tags + "</td>"; // 열 닫기
			
			tags = tags + "<td>"; // 열 시작
			tags = tags + DataClass.books.get(i).getPress();
			tags = tags + "</td>"; // 열 닫기
			
			tags = tags + "<td>"; // 열 시작
			tags = tags + DataClass.books.get(i).getPrice()+"원";
			tags = tags + "</td>"; // 열 닫기
			
			tags = tags + "<td>"; // 열 시작
			tags = tags + DataClass.books.get(i).getDiscount()+"%";
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "</tr>"; // 행 닫기
		}
		
		tags = tags + "</table>";
		tags += "</body>";
		tags += "</html>";

		
		
		return tags;
	} // makeBooksHTML() END

} // class END







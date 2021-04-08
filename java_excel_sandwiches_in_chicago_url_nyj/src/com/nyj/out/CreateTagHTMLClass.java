package com.nyj.out;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nyj.db.ChicagoClass;

public class CreateTagHTMLClass {

	public CreateTagHTMLClass() {
		// TODO Auto-generated constructor stub
	}

	public String createTagsReturn(ResultSet rs) {
		String tags = "";
		int i =0;
		tags = tags + "<!doctype html>";
		tags = tags + "<html>";
		tags = tags + "<head><title>Best Sandwich List Chicago</title></head>";
		tags = tags + "<body>";
		tags = tags + "<table border=1>";
		tags = tags + "<tr>";
		tags = tags + "<td>Rank</td>";
		tags = tags + "<td>Cafe</td>";
		tags = tags + "<td>Menu</td>";
		tags = tags + "</tr>";
		
		try {
			while(rs.next()) {
				tags = tags + "<tr>";
				tags = tags + "<td>" + rs.getInt(1)+ "</td>";
				tags = tags + "<td><a href=\"" + ChicagoClass.getBase() + rs.getString(4) +"\">" + 
				 rs.getString(2) +" </a></td>";
				tags = tags + "<td>" + rs.getString(3)+"</td>";
				tags = tags + "</tr>";
			}
			tags += "</table>" ;
			tags += "</body>" ; 
			tags += "</html>";
			System.out.println("태그 생성 완료~!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tags;
	}
	public void createFileForHTML(String uri, String tags) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(uri);
			fw.write(tags);
			fw.close();
			System.out.println("HTML 파일 생성 완료!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

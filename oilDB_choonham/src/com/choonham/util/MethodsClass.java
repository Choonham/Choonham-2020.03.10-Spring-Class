package com.choonham.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.choonham.data.DataClass;
import com.choonham.data.OilInfo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MethodsClass implements Methods {

	public MethodsClass() {

	}

	@Override
	public void readExcel(String uri) {
		File file = new File(uri);
		Workbook wb = null;
		ArrayList<String> tempArray = new ArrayList<>();
		try {
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			Cell cell = null;
			int n = 4;
			while (true) {
				try {
					for (int i = 0; i < 7; i++) {
						cell = sheet.getCell(i, n);
						tempArray.add(cell.getContents());
					}
					DataClass.oilInfoArray.add(new OilInfo(tempArray.get(0), tempArray.get(1), tempArray.get(2),
							tempArray.get(3), tempArray.get(4), tempArray.get(5), tempArray.get(6)));
					tempArray.clear();
					n++;
				} catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int setDataInto() {
		ArrayList<OilInfo> oil = DataClass.oilInfoArray;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // Localhost의 접속 주소
			Connection conn = DriverManager.getConnection(url, "choonham", "6725"); // userName 과 password 로 로그인
			System.out.println("접속 성공!!");

			for (int i = 0; i < oil.size(); i++) {
				String query = "insert into oil_data (name, address, brand, phone, self, gasoilne, diesel)  values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(query); // 객체를 얻어온다.

				pstmt.setString(1, oil.get(i).getName());
				pstmt.setString(2, oil.get(i).getAddress());
				pstmt.setString(3, oil.get(i).getBrand());
				pstmt.setString(4, oil.get(i).getPhone());
				pstmt.setInt(5, oil.get(i).isSelf());
				pstmt.setInt(6, oil.get(i).getGasoline());
				pstmt.setInt(7, oil.get(i).getDiesel());

				pstmt.executeUpdate();
			}

			System.out.println("데이터 입력이 모두 완료되었습니다.");
			conn.close();
		} catch (Exception e) {
			System.out.println("데이터 입력 중 오류가 발생했습니다. 오류 로그: " + e.getMessage());
			return -1;
		}
		return 0;
	}

	@Override
	public String makeTags() {
		String tags = "";
		int self = 0; // 셀프, 비셀프 주유소의 개수를 세기 위한 변수
		int noSelf = 0;
		tags += "<!doctype html> ";
		tags += "<html>";
		tags += "<head><title>Oil Data</title></head>";
		tags += "<body>";
		tags += "<table border='1'>";
		tags += "<tr>";
		tags += "<td>주유소 이름</td>";
		tags += "<td>주소</td>";
		tags += "<td>상호</td>";
		tags += "<td>전화번호</td>";
		tags += "<td>셀프 여부</td>";
		tags += "<td>휘발유</td>";
		tags += "<td>경유</td>";
		tags += "</tr>";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // Localhost의 접속 주소
			Connection conn = DriverManager.getConnection(url, "choonham", "6725"); // userName 과 password 로 로그인
			System.out.println("접속 성공!!");

			Statement stmt = conn.createStatement(); // 쿼리문을 실행하기 위한 객체
			String query = "select * from oil_data";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("쿼리문 실행 완료!");

			while (rs.next()) {
				tags += "<tr>";

				tags += "<td>";
				tags += rs.getString("name");
				tags += "</td>";

				tags += "<td>";
				tags += rs.getString("address");
				tags += "</td>";

				tags += "<td>";
				tags += rs.getString("brand");
				tags += "</td>";

				tags += "<td>";
				tags += rs.getString("phone");
				tags += "</td>";

				tags += "<td>";
				if (rs.getInt("self") == 1) {
					tags += "Y";
					self++;
				} else {
					noSelf++;
					tags += "N";
				}
				tags += "</td>";

				tags += "<td>";
				tags += rs.getInt("gasoilne");
				tags += "</td>";

				tags += "<td>";
				tags += rs.getInt("diesel");
				tags += "</td>";
			}
			System.out.printf("셀프 주유소의 개수: %d | 비셀프 주유소의 개수: %d \n", self, noSelf);
			tags += "</table>";
			tags += "</body>";
			tags += "</html>";
			conn.close();
		} catch (Exception e) {
			System.out.println("데이터 읽기에 실패했습니다. 오류 로그:" + e.getMessage());
		}
		return tags;
	}

	@Override
	public void makeHTML(String tags, String uri) {
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

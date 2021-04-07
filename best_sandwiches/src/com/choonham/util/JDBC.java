package com.choonham.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.choonham.data.DataClass;
import com.choonham.data.MealInfo;

public class JDBC implements JDBC_interface{
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	private final String oracleDriverPath = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final String user = "choonham";
	private final String pwd = "6725";
	
	public JDBC() {
		try {
			this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void putDataInto() {
		List<MealInfo> meal = DataClass.mealList;
		try {
			Class.forName(this.oracleDriverPath);
			System.out.println("Oracle driver has been loaded!");
			
			System.out.println("We are now in!!");
			
			for(MealInfo mi : meal) {
				String query = "INSERT INTO BEST_SANDWICHES VALUES (?, ?, ?, ?, ?, ?)";
				this.pstmt = conn.prepareStatement(query);
				this.pstmt.setInt(1, mi.getRank());
				this.pstmt.setString(2, mi.getCafe());
				this.pstmt.setString(3, mi.getMenu());
				this.pstmt.setFloat(4, mi.getPrice());
				this.pstmt.setString(5,mi.getAddress());
				this.pstmt.setString(6, mi.getImgName());
				this.pstmt.executeUpdate();
			}
			
			System.out.println("Put Data in DB!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String makeTags() {
		
		String query = "SELECT * FROM BEST_SANDWICHES ORDER BY RANK ASC";
		String tags = "";
		tags += "<!doctype html>";
		tags += "<html>\r\n" + 
				"<head><title>Best Sandwiches in Chicago</title></head>\r\n" + 
				"<body>\r\n" ;
		tags += "<table border=1>";
		tags += "<tr>";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			int n = 5;	
			while(this.rs.next()) {
				if(n==0) {
					tags += "</td>";
					tags += "<tr>";
					n = 5;
				}
				n--;
				tags += "<td>";  
				tags += "<table>" ;
				tags += "<tr><th>" + this.rs.getInt(1)+ "." + this.rs.getString(2) + "</th></tr>";
				tags += "<tr><td>" + this.rs.getString(3) + "</td></tr>";
				tags += "<tr><td><img src='../../filetest/sandwichs/images/" + this.rs.getString(6)+ "' width='100' height='100' /></td></tr>";
				tags += "<tr><td>$"+ this.rs.getFloat(4) +"</td></tr>";
				tags += "<tr><td>"+ this.rs.getString(5)+ "</td></tr> ";
				tags += "</table>" ;
			}
			tags += "</td>";
			tags += "</table>" ;
			tags += "</body>\r\n" + 
					"</html>";
			
			
			System.out.println("태그 생성 완료~!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}

	@Override
	public int countDB() {
		String query_count = "SELECT COUNT(*) FROM BEST_SANDWICHES";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query_count);
			
			if(this.rs.next())
				return rs.getInt(1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

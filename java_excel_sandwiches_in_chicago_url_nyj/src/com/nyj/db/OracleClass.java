package com.nyj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OracleClass {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	private final String oracleDriverPath = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final String user = "chicago_nyj";
	private final String pwd = "1234";
	
	public OracleClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void oracleConnect() {
		try {
			Class.forName(this.oracleDriverPath);
			System.out.println("Oracle driver has been loaded!");
			this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
			System.out.println("We are now in!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void recordInsert() {
		List<ChicagoClass> tempList = ChicagoDataClass.chicagoList;
		
		try {
			for(ChicagoClass cc : tempList) {
			String query = "INSERT INTO sandwiches_tbl VALUES (?, ?, ?, ?)";
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setInt(1, cc.getRank());
			this.pstmt.setString(2,  cc.getCafe());
			this.pstmt.setString(3,  cc.getMenu());
			this.pstmt.setString(4,  cc.getUrl());
			this.pstmt.executeUpdate();
			}
			System.out.println("Put Data in DB!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int recordCount() {
		String query_count = "SELECT COUNT(*) FROM sandwiches_tbl";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query_count);
			if(this.rs.next())
				return rs.getInt(1);
		} catch(SQLException e) {
			System.err.println("SELECT ERR : " + e.getMessage());
		}
		return 0;
	}
	
	public ResultSet recordSelect() {
		String query = "SELECT * FROM sandwiches_tbl ORDER BY RANK ASC";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			
			return this.rs;
		} catch(SQLException e) {
			System.err.println("SELECT ERR : " + e.getMessage());
		}
		return null;
	}
	
	public void close() {
		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.pstmt != null) {
				this.pstmt.close();
			}
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSE ERR : " + e.getMessage());
		}
	}

}

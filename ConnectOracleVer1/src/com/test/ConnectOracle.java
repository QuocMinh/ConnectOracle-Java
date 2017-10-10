package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectOracle {
	
	public static final String DBNAME = "orcl";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:" + DBNAME;
	public static final String USERNAME = "sys as sysdba";
	public static final String PASSWORD = "root";
	
	// TABLE NAME:
	public static final String TBL_TESTORCL = "testorcl";
	
	// SQL: 
	public static final String SL_ALL_TESTORCL = "SELECT * FROM " + TBL_TESTORCL; 

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			try {
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SL_ALL_TESTORCL);
				
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

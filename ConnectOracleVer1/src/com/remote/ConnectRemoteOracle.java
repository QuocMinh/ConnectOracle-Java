package com.remote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectRemoteOracle {
	
	public static final String DBNAME = "Utility";
	public static final String URL = "jdbc:oracle:thin:@10.151.120.241:1521:" + DBNAME;
	public static final String USERNAME = "book_so";
	public static final String PASSWORD = "book2107mf9";
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			try {
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement();
				
				System.out.println("Connected!");
				
				ResultSet rs = stmt.executeQuery(SQL.SL_ALL_BOOKING);
				
				while (rs.next()) {
					System.out.println(" | "
							+ rs.getString(1) + " | "
							+ rs.getString(2) + " | "
							+ rs.getString(3) + " | "
							+ rs.getString(4) + " | "
							+ rs.getString(5) + " | ");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

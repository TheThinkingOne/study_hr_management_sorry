package com.hr.manage.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

	static final String DB_URL = "jdbc:mysql://192.168.0.86/db_study_attend_miniproj";   // container name
	static final String USER = "cocolabhub";
	static final String PASS = "cocolabhub2024";

	private static final Connection conn;
	private static final Statement stmt;

	static {

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static Statement getConnection() {
		return stmt;
	}

	public static void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}

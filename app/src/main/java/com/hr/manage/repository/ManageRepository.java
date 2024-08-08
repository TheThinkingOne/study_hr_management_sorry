package com.hr.manage.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hr.manage.config.MySQLConnector;

public class ManageRepository {

	private final Statement stmt;

	public ManageRepository() {
		this.stmt = MySQLConnector.getConnection();
	}

	public String find() {

		String query = "";

		try {
			ResultSet resultSet = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "find data";
	}

	public String insert() throws SQLException {

		String query = "";

		try {
			System.out.println("DB update logic");
			stmt.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "update complete";
	}

}

package com.hr.manage.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hr.manage.config.MySQLConnector;
import com.hr.manage.domain.dto.request.WorkAttendanceRequestDTO;

public class ManageRepository {

	private final Statement stmt;

	public ManageRepository() {
		this.stmt = MySQLConnector.getConnection();
	}

	// responseDTO return 으로 변경
	public String find() {

		String query = "";

		try {
			ResultSet resultSet = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "find data";
	}

	public String insert(WorkAttendanceRequestDTO workAttendanceRequestDTO){

		String query = "";

		try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "근태 정보가 입력되었습니다.";
	}

	public String update(WorkAttendanceRequestDTO workAttendanceRequestDTO) {


		String query = "";

		try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "근태 정보가 수정되었습니다.";
	}

	public String delete(long id) {

		String query = "";

		try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "근태 정보가 삭제되었습니다.";
	}


}

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
	public String findDepartmentWorkAttendance(String id){

		String query = "";

/*
		try {
			ResultSet resultSet = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
*/

		System.out.println("멤버 근태 조회 로직");

		return "find data";
	}


	// responseDTO return 으로 변경
	public String findMemberWorkAttendance(String id){

		String query = "";

/*
		try {
			ResultSet resultSet = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
*/

		System.out.println("팀 근태 조회 로직");

		return "find data";
	}


	public String insert(WorkAttendanceRequestDTO workAttendanceRequestDTO){

		String query = "";
/*
		try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	*/

		System.out.println("입력 로직");

		return "근태 정보가 입력되었습니다.";
	}

	public String update(WorkAttendanceRequestDTO workAttendanceRequestDTO) {


		String query = "";

/*
		try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
*/

		return "근태 정보가 수정되었습니다.";
	}

	public String delete(String id, String date) {

		String query = "";

/*
		try {

			// stmt.executeUpdate(query);
			System.out.println("삭제 로직");

		} catch (SQLException e) {
			e.printStackTrace();
		}
*/

		return "근태 정보가 삭제되었습니다.";
	}


}

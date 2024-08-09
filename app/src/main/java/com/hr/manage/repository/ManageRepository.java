package com.hr.manage.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hr.manage.config.MySQLConnector;
import com.hr.manage.domain.dto.request.WorkAttendanceRequestDTO;
import com.hr.manage.domain.dto.response.DepartmentInfoResponseDTO;

public class ManageRepository {

	private final Statement stmt;

	public ManageRepository() {
		this.stmt = MySQLConnector.getConnection();
	}

	// responseDTO return 으로 변경
	public DepartmentInfoResponseDTO findDepartmentWorkAttendance(String departmentName){

		String query = """
				SELECT DEPT_NAME,
				       EMP_ID,
				       EMP_NAME,
				       (COUNT(CASE WHEN ATD_TYPE = '출근' THEN 1 END) / 24) * 100 AS ATTENDACE_RATE,
				       COUNT(CASE WHEN ATD_TYPE = '출근' THEN 1 END)              AS ATTENDANCE_DATE,
				       COUNT(CASE WHEN ATD_TYPE = '결근' THEN 1 END)              AS ABSENCE_DATE,
				       COUNT(CASE WHEN ATD_TYPE = '휴가' THEN 1 END)              AS VACATION_DATE
				from ATTENDANCE
				         NATURAL JOIN
				     EMPLOYEE
				         NATURAL JOIN
				     DEPARTMENT
				         NATURAL JOIN
				     ATTENDTYPE
			"""
			+ "WHERE DEPT_NAME = '" + departmentName + "'" +
			"""
				AND
				    DATE BETWEEN '2024-08-01'
				  AND '2024-08-31'
				GROUP BY
				    DEPT_NAME,
				    EMP_ID,
				    EMP_NAME
				""";

		DepartmentInfoResponseDTO departmentInfoResponseDTO = new DepartmentInfoResponseDTO();

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {

				if(departmentInfoResponseDTO.getName() == null ||departmentInfoResponseDTO.getName().isEmpty()) {
					departmentInfoResponseDTO.setName(resultSet.getString("DEPT_NAME"));
				}

				departmentInfoResponseDTO.putMemberInfos(
					resultSet.getString("EMP_NAME"),
					List.of(
						resultSet.getString("EMP_ID"),
						resultSet.getString("EMP_NAME"),
						String.valueOf(resultSet.getDouble("ATTENDACE_RATE")),
						String.valueOf(resultSet.getInt("ATTENDANCE_DATE")),
						String.valueOf(resultSet.getInt("ABSENCE_DATE")),
						String.valueOf(resultSet.getInt("VACATION_DATE"))
					)
				);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		System.out.println("멤버 근태 조회 로직");

		return departmentInfoResponseDTO;
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

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
	public DepartmentInfoResponseDTO findDepartmentWorkAttendance(String departmentName) {

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
	public String findMemberWorkAttendance(String id) {

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
		// 근태 정보 입력 쿼리 부분
		String query = """
				INSERT INTO ATTENDANCE(ATD_ID_PK, EMP_ID, DATE, ATD_TYPE_PK, DEPT_ID)
				VALUES(?,?,?,?,?)
				""";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, workAttendanceRequestDTO.getAtdIdPk()); // 고유 ID
			pstmt.setString(2, workAttendanceRequestDTO.getEmpId()); // 직원 ID
			pstmt.setString(3, workAttendanceRequestDTO.getDate()); // 날짜
			pstmt.setString(4, workAttendanceRequestDTO.getAttendTypePk()); // 근무 상태의 PK
			pstmt.setString(5, workAttendanceRequestDTO.getDeptId()); // 부서 ID

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return "근태 정보 입력 중 오류 발생";
		}

		System.out.println("입력 로직");

		return "근태 정보가 입력되었습니다.";
	}

	public String update(WorkAttendanceRequestDTO workAttendanceRequestDTO) {
		// 근태 정보 수정 쿼리 부분

		String query = """
				UPDATE ATTENDANCE
				SET ATD_TYPE_PK = ?
				WHERE EMP_ID = ?
				AND DATE = ?
				""";

		/*try {

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, workAttendanceRequestDTO.getAttendTypePk()); // 새로운 근무 상태의 PK
			pstmt.setString(2, workAttendanceRequestDTO.getEmpId()); // 직원 ID
			pstmt.setString(3, workAttendanceRequestDTO.getDate()); // 날짜

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return "근태 정보 수정 중 오류 발생";
		}

		return "근태 정보가 수정되었습니다.";
	}

	public String delete(String id, String date) {
		// 근태 정보 삭제 쿼리 부분
		String query = """
				DELETE FROM ATTENDANCE
				WHERE EMP_ID = ?
				AND DATE = ?
				""";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, id); // 직원 ID
			pstmt.setString(2, date); // 날짜

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return "근태 정보 삭제 중 오류 발생";
		}

		return "근태 정보가 삭제되었습니다.";
	}


}

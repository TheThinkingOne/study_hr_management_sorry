package com.hr.manage.domain.dto.response;

import java.util.Map;

public class MemberInfoResponseDTO {

	private String ID;
	private String name;
	private String department;

	// key : date value : 출근 or 휴가
	private Map<String, String> workAttendanceDetails;

	public MemberInfoResponseDTO(String ID, String name, String department, Map<String, String> workAttendanceDetails) {
		this.ID = ID;
		this.name = name;
		this.department = department;
		this.workAttendanceDetails = workAttendanceDetails;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public Map<String, String> getWorkAttendanceDetails() {
		return workAttendanceDetails;
	}
}

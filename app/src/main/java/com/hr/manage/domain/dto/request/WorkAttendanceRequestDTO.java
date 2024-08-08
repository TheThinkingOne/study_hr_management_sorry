package com.hr.manage.domain.dto.request;

public class WorkAttendanceRequestDTO {

	private long id;
	private String date;
	private String attendanceStatus;

	public WorkAttendanceRequestDTO(long id, String date, String attendanceStatus) {
		this.id = id;
		this.date = date;
		this.attendanceStatus = attendanceStatus;
	}

	public long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}
}

package com.hr.manage.domain.dto.request;

public class WorkAttendanceRequestDTO {

	private long id;
	private String date;
	private String attendanceStatus;

	public WorkAttendanceRequestDTO() {
	}

	public WorkAttendanceRequestDTO(long id, String date, String attendanceStatus) {
		this.id = id;
		this.date = date;
		this.attendanceStatus = attendanceStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
}

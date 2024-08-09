package com.hr.manage.domain.dto.request;

public class WorkAttendanceRequestDTO {

	private String ID;
	private String date;
	private String attendanceStatus;

	public WorkAttendanceRequestDTO() {
	}

	public WorkAttendanceRequestDTO(String ID, String date, String attendanceStatus) {
		this.ID = ID;
		this.date = date;
		this.attendanceStatus = attendanceStatus;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

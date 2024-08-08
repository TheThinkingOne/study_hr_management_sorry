package com.hr.manage.view;

import java.util.Scanner;

public class InputPrinter {

	public static String CHOOSE_MESSAGE = "선택하세요 : ";
	public static String USER_ID_MESSAGE = "직원 ID 입력: [EX: 12345] ";
	public static String DATE_MESSAGE = "날짜 입력 (YYYY-MM-DD): [EX: 2024-08-01] ";
	public static String WORK_ATTENDANCE_MESSAGE = "근무 상태 입력 (출근/퇴근/휴가 등): [EX: 출근] ";

	Scanner scanner;

	public InputPrinter() {
		this.scanner = new Scanner(System.in);
	}

	public String inputString(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public int inputInt(String message) {
		System.out.print(message);
		return scanner.nextInt();
	}

}

package com.hr.manage.view;

import com.hr.manage.domain.MemberInfo;

public class OutputPrinter {

	public OutputPrinter() {
	}

	public void printAA() {
		System.out.println("화면 출력문");
	}

	public void printMainOption() {
		System.out.println(
			"==== 인적 자원 관리 시스템 ====\n"
				+ "\n"
				+ "1. 조직/직무 관리\n"
				+ "2. 인사행정\n"
				+ "3. 근태 관리\n"
				+ "4. 급여/정산\n"
				+ "5. 사회보험\n"
				+ "6. 평가 관리\n"
				+ "7. 연말정산\n"
				+ "8. 승진 관리\n"
				+ "9. 핵심 인재 관리\n"
				+ "10. 월별 종합 현황 보기\n"
				+ "0. 종료\n"
		);
	}

	public void printManageOption() {
		System.out.println(
			"==== 근태 관리 ====\n"
				+ "\n"
				+ "1. 근태 입력\n"
				+ "2. 근태 수정 *\n"
				+ "3. 근태 삭제 *\n"
				+ "4. 직원별 월별 근태 현황 보기\n"
				+ "5. 부서별 월별 근태 현황 보기\n"
				+ "0. 메인 메뉴로 돌아가기\n"
		);
	}

	public void printWorkAttendanceStart() {
		System.out.println("\n"
			+ "==== 근태 입력 ====\n"
		);
	}

	public void printWorkAttendanceEnd() {
		System.out.println("\n근태 정보가 입력되었습니다.\n");
	}

	public void printMemberWorkAttendanceStatus(MemberInfo memberInfo) {

		System.out.println("직원 ID: " + memberInfo.getID());
		System.out.println("이름: " + memberInfo.getName());
		System.out.println("부서: " + memberInfo.getDepartment());

		System.out.println("출력문 추가구현");
	}

	public void printDeleteAttendanceEndMessage() {
		System.out.println("근태 수정 완료");
	}
	public void printUpdateAttendanceEndMessage() {
		System.out.println("근태 삭제 완료");
	}


}

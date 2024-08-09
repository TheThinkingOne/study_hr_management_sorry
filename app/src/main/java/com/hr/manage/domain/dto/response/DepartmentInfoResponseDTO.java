package com.hr.manage.domain.dto.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentInfoResponseDTO {

	private String name;
	// key : 사원 이름 value : 사원 id, 이름, 출근율, 출근,결근,휴가 일수 순서로
	private Map<String, List<String>> memberInfos;

	public DepartmentInfoResponseDTO(String name, Map<String, List<String>> memberInfos) {
		this.name = name;
		this.memberInfos = memberInfos;
	}

	public DepartmentInfoResponseDTO() {
		memberInfos = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, List<String>> getMemberInfos() {
		return memberInfos;
	}

	public void putMemberInfos(String memberName, List<String> memberInfos) {
		this.memberInfos.put(memberName, memberInfos);
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("부서: ").append(name).append("\n");
		stringBuilder.append("\n2024년 8월 근태 현황:\n");

		for (String key : memberInfos.keySet()) {

			List<String> infos = memberInfos.get(key);
			stringBuilder.append("- 직원ID: ").append(infos.get(0)).append("\n");
			stringBuilder.append("	- 이름: ").append(infos.get(1)).append("\n");
			stringBuilder.append("	- 출근율: ").append(infos.get(2)).append("%").append("\n");
			stringBuilder.append("	- 출근: ").append(infos.get(3)).append("일").append("\n");
			stringBuilder.append("	- 결근: ").append(infos.get(4)).append("일").append("\n");
			stringBuilder.append("	- 휴가: ").append(infos.get(5)).append("일").append("\n");
		}

		return stringBuilder.toString();
	}
}

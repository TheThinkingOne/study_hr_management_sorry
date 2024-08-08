package com.hr.manage.domain.dto.response;

import java.util.List;
import java.util.Map;

public class DepartmentInfoResponseDTO {

	private String name;

	// key : 사원 이름 value : 사원 id, 이름, 출근율, 출근,결근,휴가 일수 순서로
	private Map<String, List<String>> memberInfos;

}

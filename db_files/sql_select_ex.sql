-- 특정 직원의 총 출근 일수, 총 결근 일수, 총 휴가 일수를 조회하는 쿼리
SELECT e.EMP_ID AS '직원 ID', e.EMP_NAME AS '이름', d.DEPT_NAME AS '부서', COUNT(CASE WHEN at.ATD_TYPE = '출근' THEN 1 END) AS '총 출근 일수', COUNT(CASE WHEN at.ATD_TYPE = '결근' THEN 1 END) AS '총 결근 일수', COUNT(CASE WHEN at.ATD_TYPE = '휴가' THEN 1 END) AS '총 휴가 일수'
FROM ATTENDANCE a
         JOIN
     EMPLOYEE e ON a.EMP_ID = e.EMP_ID
         JOIN
     DEPARTMENT d ON e.DEPT_ID = d.DEPT_ID_PK
         JOIN
     ATTENDTYPE at
ON a.ATD_TYPE_PK = at.ATD_TYPE_PK
WHERE
    e.EMP_ID = '12345' -- 특정 직원의 ID를 지정
  AND a.DATE BETWEEN '2024-08-01'
  AND '2024-08-31'     -- 날짜 범위를 지정
GROUP BY
    e.EMP_ID, e.EMP_NAME, d.DEPT_NAME;


-- 특정 부서의 직원별 출근율 및 근태 현황을 조회하는 쿼리

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
WHERE DEPT_NAME = 'HR'
  AND
    DATE BETWEEN '2024-08-01'
  AND '2024-08-31'
GROUP BY
    DEPT_NAME,
    EMP_ID,
    EMP_NAME;







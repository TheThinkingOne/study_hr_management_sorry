-- 1. 직원별 2024년 8월의 근태 현황 (날짜별 근태 상태)
SELECT e.EMP_ID, e.EMP_NAME, d.DEPT_NAME,
       mt.DATE_PK AS 날짜, atd.ATD_TYPE AS 근무상태
FROM MT_ATD_EMP mt
         JOIN EMP_ID e ON mt.EMP_ID_PK = e.EMP_ID_PK
         JOIN DATE d ON mt.DATE_PK = d.DATE_PK
         JOIN ATD_TYPE atd ON mt.ATD_TYPE_PK = atd.ATD_TYPE_PK
         JOIN DEPT_EMP_TABLE det ON e.EMP_ID_PK = det.EMP_ID_PK
         JOIN DEPT d ON det.DEPT_PK = d.DEPT_PK
WHERE mt.EMP_ID_PK = '12345'  -- 직원 ID를 필터링
  AND mt.DATE_PK BETWEEN '2024-08-01' AND '2024-08-31'
ORDER BY mt.DATE_PK;

-- 직원별 총 출근일수, 결근일수, 휴가일수
SELECT
    e.EMP_ID, e.EMP_NAME,
    COUNT(CASE WHEN atd.ATD_TYPE = '출근' THEN 1 END) AS 출근일수,
    COUNT(CASE WHEN atd.ATD_TYPE = '결근' THEN 1 END) AS 결근일수,
    COUNT(CASE WHEN atd.ATD_TYPE = '휴가' THEN 1 END) AS 휴가일수
FROM MT_ATD_EMP mt
         JOIN EMP_ID e ON mt.EMP_ID_PK = e.EMP_ID_PK
         JOIN ATD_TYPE atd ON mt.ATD_TYPE_PK = atd.ATD_TYPE_PK
WHERE mt.EMP_ID_PK = '12345'  -- 직원 ID를 필터링, 여기에 ? 넣어서 원하는 직원 아이디 넣어주시면 될 것 같아요
  AND mt.DATE_PK BETWEEN '2024-08-01' AND '2024-08-31'
GROUP BY e.EMP_ID, e.EMP_NAME;



-- 3. 부서별 2024년 8월의 근태 현황 (각 직원별)
SELECT
    d.DEPT_NAME AS 부서,
    e.EMP_ID, e.EMP_NAME,
    COUNT(CASE WHEN atd.ATD_TYPE = '출근' THEN 1 END) AS 출근일수,
    COUNT(CASE WHEN atd.ATD_TYPE = '결근' THEN 1 END) AS 결근일수,
    COUNT(CASE WHEN atd.ATD_TYPE = '휴가' THEN 1 END) AS 휴가일수,
    ROUND((COUNT(CASE WHEN atd.ATD_TYPE = '출근' THEN 1 END) * 100.0) / 31, 2) AS 출근율  -- 31일 기준
FROM MT_ATD_EMP mt
         JOIN EMP_ID e ON mt.EMP_ID_PK = e.EMP_ID_PK
         JOIN DATE d ON mt.DATE_PK = d.DATE_PK
         JOIN ATD_TYPE atd ON mt.ATD_TYPE_PK = atd.ATD_TYPE_PK
         JOIN DEPT_EMP_TABLE det ON e.EMP_ID_PK = det.EMP_ID_PK
         JOIN DEPT d ON det.DEPT_PK = d.DEPT_PK
WHERE d.DEPT_NAME = '개발팀'  -- 부서명을 필터링, 여기에 ? 넣어서 원하는 개발팀 넣어주시면 될 것 같아요
  AND mt.DATE_PK BETWEEN '2024-08-01' AND '2024-08-31'
GROUP BY d.DEPT_NAME, e.EMP_ID, e.EMP_NAME;


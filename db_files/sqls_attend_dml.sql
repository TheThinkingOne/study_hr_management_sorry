-- 근태 정보 입력 쿼리
INSERT INTO `ATTENDANCE` (`ATD_ID_PK`, `EMP_ID`, `DATE`, `ATD_TYPE_PK`, `DEPT_ID`)
VALUES (
    CONCAT('A', LPAD(FLOOR(RAND() * 10000), 4, '0')), -- 고유한 ATD_ID_PK 생성
    ?, -- 여기에 직원 ID
    ?, -- 여기에 날짜
    ?, -- 여기에 근무 상태에 해당하는 ATD_TYPE_PK
    (SELECT `DEPT_ID_PK` FROM `EMPLOYEE` WHERE `EMP_ID` = ?) -- 여기에 직원 ID
);

-- 근태 정보 수정(업데이트) 쿼리
UPDATE `ATTENDANCE`
SET `ATD_TYPE_PK` = (
    SELECT `ATD_TYPE_PK`
    FROM `ATTENDTYPE`
    WHERE `ATD_TYPE` = '결근' -- 여기에 ? 
)
WHERE `EMP_ID` = '12345' -- 여기에 ?
AND `DATE` = '2024-08-31'; -- 여기에 ?

-- 근태 삭제 쿼리
DELETE FROM `ATTENDANCE`
WHERE `EMP_ID` = ?
AND `DATE` = ?;



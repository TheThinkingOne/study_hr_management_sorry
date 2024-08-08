CREATE TABLE `DEPT` (
	`DEPT_PK`	VARCHAR(20)	NOT NULL,
	`DEPT_NAME`	VARCHAR(20)	NULL
);

CREATE TABLE `ATD_TYPE` (
	`ATD_TYPE_PK`	VARCHAR(20)	NOT NULL,
	`ATD_TYPE`	VARCHAR(20)	NULL
);

CREATE TABLE `DATE` (
	`DATE_PK`	VARCHAR(20)	NOT NULL,
	`DATE`	VARCHAR(20)	NULL
);

CREATE TABLE `DEPT_EMP_TABLE` (
	`DEPT_EMP_PK`	VARCHAR(20)	NOT NULL,
	`EMP_ID_PK`	VARCHAR(20)	NOT NULL,
	`DEPT_PK`	VARCHAR(20)	NOT NULL
);

CREATE TABLE `MT_ATD_EMP` (
	`MT_ATD_EMP_PK`	VARCHAR(20)	NOT NULL,
	`EMP_ID_PK`	VARCHAR(20)	NOT NULL,
	`DATE_PK`	VARCHAR(20)	NOT NULL,
	`ATD_TYPE_PK`	VARCHAR(20)	NOT NULL
);

CREATE TABLE `MT_ATD_DEPT` (
	`MT_ATD_DEPT_PK`	VARCHAR(20)	NOT NULL,
	`MT_ATD_EMP_FK`	VARCHAR(20)	NOT NULL,
	`EMP_ID_FK`	VARCHAR(20)	NOT NULL,
	`DATE_FK`	VARCHAR(20)	NOT NULL,
	`ATD_TYPE_FK`	VARCHAR(20)	NOT NULL
);

CREATE TABLE `EMP_ID` (
	`EMP_ID_PK`	VARCHAR(20)	NOT NULL,
	`EMP_ID`	VARCHAR(20)	NULL,
	`EMP_NAME`	VARCHAR(20)	NULL
);

ALTER TABLE `DEPT` ADD CONSTRAINT `PK_DEPT` PRIMARY KEY (
	`DEPT_PK`
);

ALTER TABLE `ATD_TYPE` ADD CONSTRAINT `PK_ATD_TYPE` PRIMARY KEY (
	`ATD_TYPE_PK`
);

ALTER TABLE `DATE` ADD CONSTRAINT `PK_DATE` PRIMARY KEY (
	`DATE_PK`
);

ALTER TABLE `DEPT_EMP_TABLE` ADD CONSTRAINT `PK_DEPT_EMP_TABLE` PRIMARY KEY (
	`DEPT_EMP_PK`,
	`EMP_ID_PK`,
	`DEPT_PK`
);

ALTER TABLE `MT_ATD_EMP` ADD CONSTRAINT `PK_MT_ATD_EMP` PRIMARY KEY (
	`MT_ATD_EMP_PK`,
	`EMP_ID_PK`,
	`DATE_PK`,
	`ATD_TYPE_PK`
);

ALTER TABLE `MT_ATD_DEPT` ADD CONSTRAINT `PK_MT_ATD_DEPT` PRIMARY KEY (
	`MT_ATD_DEPT_PK`,
	`MT_ATD_EMP_FK`,
	`EMP_ID_FK`,
	`DATE_FK`,
	`ATD_TYPE_FK`
);

ALTER TABLE `EMP_ID` ADD CONSTRAINT `PK_EMP_ID` PRIMARY KEY (
	`EMP_ID_PK`
);

ALTER TABLE `DEPT_EMP_TABLE` ADD CONSTRAINT `FK_EMP_ID_TO_DEPT_EMP_TABLE_1` FOREIGN KEY (
	`EMP_ID_PK`
)
REFERENCES `EMP_ID` (
	`EMP_ID_PK`
);

ALTER TABLE `DEPT_EMP_TABLE` ADD CONSTRAINT `FK_DEPT_TO_DEPT_EMP_TABLE_1` FOREIGN KEY (
	`DEPT_PK`
)
REFERENCES `DEPT` (
	`DEPT_PK`
);

ALTER TABLE `MT_ATD_EMP` ADD CONSTRAINT `FK_EMP_ID_TO_MT_ATD_EMP_1` FOREIGN KEY (
	`EMP_ID_PK`
)
REFERENCES `EMP_ID` (
	`EMP_ID_PK`
);

ALTER TABLE `MT_ATD_EMP` ADD CONSTRAINT `FK_DATE_TO_MT_ATD_EMP_1` FOREIGN KEY (
	`DATE_PK`
)
REFERENCES `DATE` (
	`DATE_PK`
);

ALTER TABLE `MT_ATD_EMP` ADD CONSTRAINT `FK_ATD_TYPE_TO_MT_ATD_EMP_1` FOREIGN KEY (
	`ATD_TYPE_PK`
)
REFERENCES `ATD_TYPE` (
	`ATD_TYPE_PK`
);

ALTER TABLE `MT_ATD_DEPT` ADD CONSTRAINT `FK_MT_ATD_EMP_TO_MT_ATD_DEPT_1` FOREIGN KEY (
	`MT_ATD_EMP_FK`
)
REFERENCES `MT_ATD_EMP` (
	`MT_ATD_EMP_PK`
);

ALTER TABLE `MT_ATD_DEPT` ADD CONSTRAINT `FK_MT_ATD_EMP_TO_MT_ATD_DEPT_2` FOREIGN KEY (
	`EMP_ID_FK`
)
REFERENCES `MT_ATD_EMP` (
	`EMP_ID_PK`
);

ALTER TABLE `MT_ATD_DEPT` ADD CONSTRAINT `FK_MT_ATD_EMP_TO_MT_ATD_DEPT_3` FOREIGN KEY (
	`DATE_FK`
)
REFERENCES `MT_ATD_EMP` (
	`DATE_PK`
);

ALTER TABLE `MT_ATD_DEPT` ADD CONSTRAINT `FK_MT_ATD_EMP_TO_MT_ATD_DEPT_4` FOREIGN KEY (
	`ATD_TYPE_FK`
)
REFERENCES `MT_ATD_EMP` (
	`ATD_TYPE_PK`
);


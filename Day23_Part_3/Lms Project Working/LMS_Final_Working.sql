drop database if exists lms;

create database lms;

-- change this to your team id
use lms;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table
CREATE TABLE EMPLOYEE
 ( 
EMP_ID INT PRIMARY KEY ,
EMP_NAME CHAR(20) NOT NULL,
EMP_MAIL CHAR(30) NOT NULL,
EMP_MOB_NO BIGINT NOT NULL,
EMP_DT_JOIN DATE NOT NULL,
EMP_DEPT CHAR(25),
EMP_MANAGER_ID INT,
EMP_AVAIL_LEAVE_BAL INT,
FOREIGN KEY (EMP_MANAGER_ID)
REFERENCES EMPLOYEE(EMP_ID)
);

drop table if exists leave_history;

-- create the table
CREATE TABLE LEAVE_HISTORY
(
LEAVE_ID INT PRIMARY KEY AUTO_INCREMENT,
LEAVE_NO_OF_DAYS INT,
LEAVE_MNGR_COMMENTS CHAR(200),
EMP_ID INT,
LEAVE_START_DATE DATE NOT NULL, 
LEAVE_END_DATE DATE NOT NULL,
LEAVE_TYPE ENUM ('EL' ) DEFAULT 'EL',
LEAVE_STATUS ENUM ('PENDING','APPROVED','DENIED') DEFAULT 'PENDING',
LEAVE_REASON  CHAR(50) NOT NULL,
-- LEAVE_APPLIED_ON  DATE NOT NULL,
FOREIGN KEY(EMP_ID) REFERENCES EMPLOYEE(EMP_ID)
);



INSERT INTO EMPLOYEE VALUES(1000,
'ABHILASH',
'AbhilashP@hexaware.com', 
7772021561,'2017-11-14',
'HEXAVARSITY',NULL,20);
INSERT INTO EMPLOYEE VALUES(2000,
'SANDEEP',
'SandeepM@hexaware.com', 
9853969055,'2017-11-14',
'HEXAVARSITY',1000,20);

INSERT INTO EMPLOYEE VALUES(2001,
'SHIKHA',
'ShikhaR@hexaware.com', 
7987753369,'2017-11-14',
'HEXAVARSITY',1000,15);
INSERT INTO EMPLOYEE VALUES(3000,
'AISHWARYA',
'AishwaryaT2@hexaware.com', 
9424401658,'2017-11-14',
'HEXAVARSITY',2000,18);

INSERT INTO EMPLOYEE VALUES(3001,
'SURABHI',
'SurabhiG@hexaware.com', 
7566008477,'2017-11-14',
'HEXAVARSITY',2001,20);

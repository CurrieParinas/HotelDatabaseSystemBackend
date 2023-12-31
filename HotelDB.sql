CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID         NUMBER(11, 0),
    FIRST_NAME          VARCHAR(30),
    MIDDLE_NAME         VARCHAR(20),
    LAST_NAME           VARCHAR(20),
    BIRTHDAY            DATE DEFAULT SYSDATE,
    ADDRESS             VARCHAR(70),
    CONTACT_NUMBER      NUMBER(11),
    EMAIL_ADDRESS       VARCHAR(40),
    AGE                 NUMBER(3, 0),
    SALARY              NUMBER(8, 2),
    SUPERVISOR          NUMBER(11, 0),
    EMPLOYEE_TYPE       VARCHAR(2),
CONSTRAINT EMPLOYEE_PK PRIMARY KEY (EMPLOYEE_ID),
CONSTRAINT EMPLOYEE_FK1 FOREIGN KEY (SUPERVISOR) REFERENCES EMPLOYEE(EMPLOYEE_ID));

CREATE TABLE BRN (
    BRN_ID              VARCHAR(6),
    EMPLOYEE_ID         NUMBER(11, 0),
    BOOKING_DATE        DATE DEFAULT SYSDATE,
    CHECK_IN_DATE       DATE DEFAULT SYSDATE,
    CHECK_OUT_DATE      DATE DEFAULT SYSDATE,
    STATUS              VARCHAR(11),
    TOTAL_COST          NUMBER(9, 2),
CONSTRAINT BRN_PK PRIMARY KEY (BRN_ID),
CONSTRAINT BRN_FK1 FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID));

CREATE TABLE ACCOUNTS (
    EMPLOYEE_ID         NUMBER(11, 0),
    EMAIL               VARCHAR(50),
    PASSWORD            VARCHAR(30),
CONSTRAINT ACCOUNT_PK PRIMARY KEY (EMPLOYEE_ID),
CONSTRAINT ACCOUNT_FK1 FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID));

CREATE TABLE GUEST (
    GUEST_ID            NUMBER(11, 0),
    BRN_ID              VARCHAR(6),
    FIRST_NAME          VARCHAR(30),
    MIDDLE_NAME         VARCHAR(20),
    LAST_NAME           VARCHAR(20),
    BIRTHDAY            DATE DEFAULT SYSDATE,
    ADDRESS             VARCHAR(70),
    CONTACT_NUMBER      NUMBER(11),
    EMAIL_ADDRESS       VARCHAR(40),
    AGE                 NUMBER(3, 0),
    GUEST_TYPE          VARCHAR(1),
CONSTRAINT GUEST_PK PRIMARY KEY (GUEST_ID),
CONSTRAINT GUEST_FK1 FOREIGN KEY (BRN_ID) REFERENCES BRN(BRN_ID));

CREATE TABLE ROOM_TYPE (
    ROOM_TYPE           NUMBER(1, 0),
    ROOM_NAME           VARCHAR(9),
    DESCRIPTION         VARCHAR(255),
    PRICE               NUMBER(7, 2),
    MAX_GUESTS          NUMBER(2, 0),
    BEDS                NUMBER(2, 0),
    AREA                NUMBER(5, 2),
CONSTRAINT ROOM_TYPE_PK PRIMARY KEY (ROOM_TYPE));

CREATE TABLE ROOM (
    ROOM_NUMBER         NUMBER(11, 0),
    ROOM_TYPE           NUMBER(1, 0),
CONSTRAINT ROOM_PK PRIMARY KEY (ROOM_NUMBER),
CONSTRAINT ROOM_FK1 FOREIGN KEY (ROOM_TYPE) REFERENCES ROOM_TYPE(ROOM_TYPE));

CREATE TABLE CHARGE (
    CHARGE_ID       NUMBER(11, 0),
    BRN_ID          VARCHAR(6),
    ROOM_NUMBER     NUMBER(3, 0),
    COST            NUMBER(7, 2),
CONSTRAINT CHARGE_PK PRIMARY KEY (CHARGE_ID),
CONSTRAINT CHARGE_FK1 FOREIGN KEY (BRN_ID) REFERENCES BRN(BRN_ID),
CONSTRAINT CHARGE_FK2 FOREIGN KEY (ROOM_NUMBER) REFERENCES ROOM(ROOM_NUMBER));

CREATE TABLE SERVICE (
    SERVICE_ID          NUMBER(11, 0),
    SERVICE_NAME        VARCHAR(30),
    EMPLOYEE_TYPE       VARCHAR(2),
CONSTRAINT SERVICE_PK PRIMARY KEY (SERVICE_ID));

CREATE TABLE SERVICE_LINE (
    SERVICE_LINE_ID     NUMBER(11, 0),
    CHARGE_ID           NUMBER(11, 0),
    SERVICE_ID          NUMBER(11, 0),
    EMPLOYEE_ID         NUMBER(11, 0),
    SERVICE_DATE        DATE DEFAULT SYSDATE,
CONSTRAINT SERVICE_LINE_PK PRIMARY KEY (SERVICE_LINE_ID),
CONSTRAINT SERVICE_LINE_FK1 FOREIGN KEY (CHARGE_ID) REFERENCES CHARGE(CHARGE_ID),
CONSTRAINT SERVICE_LINE_FK2 FOREIGN KEY (SERVICE_ID) REFERENCES SERVICE(SERVICE_ID),
CONSTRAINT SERVICE_LINE_FK3 FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID));

CREATE TABLE SERVICE_ROOM_TYPE (
    ROOM_TYPE           NUMBER(1, 0),
    SERVICE_ID          NUMBER(11, 0),
    PRICE               NUMBER(7, 2),
CONSTRAINT SRT_PK PRIMARY KEY (SERVICE_ID, ROOM_TYPE),
CONSTRAINT SRT_FK1 FOREIGN KEY (ROOM_TYPE) REFERENCES ROOM_TYPE(ROOM_TYPE),
CONSTRAINT SRT_FK2 FOREIGN KEY (SERVICE_ID) REFERENCES SERVICE(SERVICE_ID));

CREATE TABLE PAYMENT_DETAILS (
    PAYMENT_DETAIL_ID       NUMBER(11, 0),
    BRN_ID                  VARCHAR(6),
    MODE_OF_PAYMENT         VARCHAR(20),
    CARD_NUMBER             NUMBER(10, 0),
    CVV                     NUMBER(3, 0),
    EXPIRATION_DATE         DATE DEFAULT SYSDATE,
CONSTRAINT PAYMENT_DETAIL_PK PRIMARY KEY (PAYMENT_DETAIL_ID),
CONSTRAINT PAYMENT_DETAIL_FK1 FOREIGN KEY (BRN_ID) REFERENCES BRN(BRN_ID));

INSERT INTO ROOM_TYPE VALUES (1, 'Deluxe', 'Wowsers', 1000, 5, 3, 100);
INSERT INTO ROOM VALUES (100, 1);
INSERT INTO ROOM VALUES (101, 1);
INSERT INTO ROOM VALUES (102, 1);

SELECT * FROM BRN

INSERT INTO EMPLOYEE(EMPLOYEE_ID, FIRST_NAME) VALUES (1, 'Ron');
INSERT INTO ACCOUNTS VALUES (1, 'rsgomez1@up.edu.ph', '123');

INSERT INTO BRN(BRN_ID, EMPLOYEE_ID, STATUS) VALUES ('ASD696', 1, 'CHECKED-IN');
INSERT INTO BRN(BRN_ID, EMPLOYEE_ID, STATUS) VALUES ('ASD698', 1, 'CHECKED-OUT');
INSERT INTO BRN(BRN_ID, EMPLOYEE_ID, STATUS) VALUES ('ASD699', 1, 'CHECKED-OUT');


INSERT INTO CHARGE(CHARGE_ID, BRN_ID, ROOM_NUMBER) VALUES (1, 'ASD696', 100);
INSERT INTO CHARGE(CHARGE_ID, BRN_ID, ROOM_NUMBER) VALUES (2, 'ASD698', 100);
INSERT INTO CHARGE(CHARGE_ID, BRN_ID, ROOM_NUMBER) VALUES (3, 'ASD699', 101);
INSERT INTO CHARGE(CHARGE_ID, BRN_ID, ROOM_NUMBER) VALUES (4, 'ASD696', 101);


SELECT R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA
FROM ROOM R LEFT JOIN ROOM_TYPE RT on R.ROOM_TYPE = RT.ROOM_TYPE
            LEFT JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
            LEFT JOIN BRN B ON C.BRN_ID = B.BRN_ID
WHERE R.ROOM_NUMBER NOT IN (SELECT R.ROOM_NUMBER
                            FROM ROOM R JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
                                        JOIN BRN B ON C.BRN_ID = B.BRN_ID
                            WHERE B.BRN_ID NOT IN (SELECT BRN_ID FROM BRN WHERE STATUS = 'CHECKED-OUT')
                            GROUP BY R.ROOM_NUMBER)
GROUP BY R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA

SELECT R.ROOM_NUMBER, B.BRN_ID
FROM ROOM R JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
            JOIN BRN B ON C.BRN_ID = B.BRN_ID
WHERE STATUS != 'CHECKED-OUT';

SELECT G.FIRST_NAME, G.MIDDLE_NAME, G.LAST_NAME
FROM GUEST G JOIN BRN B ON G.BRN_ID = B.BRN_ID
WHERE G.BRN_ID = ?1 AND GUEST_TYPE = 'P';

SELECT SERVICE_NAME, PRICE, SERVICE_DATE
FROM SERVICE    JOIN SERVICE_LINE SL ON SERVICE.SERVICE_ID = SL.SERVICE_ID
                JOIN CHARGE C ON SL.CHARGE_ID = C.CHARGE_ID
                JOIN ROOM R ON C.ROOM_NUMBER = R.ROOM_NUMBER
                JOIN BRN B ON C.BRN_ID = B.BRN_ID
                JOIN SERVICE_ROOM_TYPE SRT on SERVICE.SERVICE_ID = SRT.SERVICE_ID
WHERE C.ROOM_NUMBER = ?1 AND C.BRN_ID = ?2 AND EMPLOYEE_TYPE = ?3;

SELECT BRN_ID
FROM BRN
WHERE STATUS != 'CHECKED-OUT';

SELECT ROOM_NUMBER
FROM CHARGE
WHERE BRN_ID = ?1;

commit;
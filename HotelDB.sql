CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID         NUMBER(11, 0),
    FIRST_NAME          VARCHAR(30),
    MIDDLE_NAME         VARCHAR(20),
    LAST_NAME           VARCHAR(20),
    BIRTHDAY            DATE DEFAULT SYSDATE,
    ADDRESS             VARCHAR(200),
    CONTACT_NUMBER      NUMBER(10),
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
    CONTACT_NUMBER      NUMBER(10),
    EMAIL_ADDRESS       VARCHAR(40),
    AGE                 NUMBER(3, 0),
    GUEST_TYPE          VARCHAR(1),
CONSTRAINT GUEST_PK PRIMARY KEY (GUEST_ID),
CONSTRAINT GUEST_FK1 FOREIGN KEY (BRN_ID) REFERENCES BRN(BRN_ID));

CREATE TABLE ROOM_TYPE (
    ROOM_TYPE           NUMBER(1, 0),
    ROOM_NAME           VARCHAR(9),
    DESCRIPTION         VARCHAR(500),
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
    SERVICE_TYPE        VARCHAR(30),
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

INSERT INTO EMPLOYEE VALUES (1, 'Ron Brylle', 'San Gabriel', 'Gomez', TO_DATE('2002-11-09', 'YYYY-MM-DD'), 'Ikaw pa rin tahanan ko, Valenzuela City', 9270442113, 'rsgomez1@up.edu.ph', 21, 69420, 1, 'S');
INSERT INTO EMPLOYEE VALUES (2, 'Marvin Andrew', 'Sarile', 'Rosales', TO_DATE('2003-03-04', 'YYYY-MM-DD'), 'Paco,Manila', 9159277857, 'msrosales@up.edu.ph', 20, 69420, 1, 'S');

INSERT INTO ACCOUNTS VALUES (1, 'rsgomez1@up.edu.ph', 'imissyou');

INSERT INTO ROOM_TYPE VALUES (1, 'Deluxe', 'Indulge in the comfort of the Deluxe Room, where contemporary elegance meets practical luxury. Thoughtfully designed with modern amenities and stylish décor, this room provides a relaxing retreat for both business and leisure.', 10000, 2, 1, 15);
INSERT INTO ROOM_TYPE VALUES (2, 'Grand', 'Indulge in a heightened sense of luxury with the Grand Room. Designed for those seeking extra space and upscale amenities, the Grand Room offers a spacious retreat with a touch of sophistication. Revel in the tasteful decor, upgraded furnishings, and a range of exclusive services, making your stay truly exceptional.', 15000, 4, 2, 20);
INSERT INTO ROOM_TYPE VALUES (3, 'Suite', 'Elevate your stay to a new level of luxury with our exquisite suites. These meticulously designed spaces offer a blend of opulence and functionality, providing a separate area for added comfort and privacy. Immerse yourself in the refined ambiance, enjoy personalized services, and enjoy our thoughtfully curated suites.', 20000, 6, 3, 30);
INSERT INTO ROOM_TYPE VALUES (4, 'Executive', 'Experience unparalleled luxury in our executive room, where sophistication meets comfort. This spacious and finely appointed room offers a perfect blend of modern amenities and classic elegance. Indulge in a restful night''s sleep on a king-size bed, unwind in the separate living area, and enjoy exclusive access to premium services.', 25000, 8, 2, 40);

INSERT INTO ROOM VALUES(105,1);
INSERT INTO ROOM VALUES(106,2);
INSERT INTO ROOM VALUES(107,3);
INSERT INTO ROOM VALUES(108,4);

INSERT INTO SERVICE VALUES(1, 'Massage Therapy','Spas','C');
INSERT INTO SERVICE VALUES(2, 'Facial Therapy','Spas','C');
INSERT INTO SERVICE VALUES(3, 'Water Therapy','Spas','C');
INSERT INTO SERVICE VALUES(4, 'Event Planning','Activities','C');
INSERT INTO SERVICE VALUES(5, 'Island Hopping','Activities','C');
INSERT INTO SERVICE VALUES(6, 'Day Tour (Land)','Activities','C');
INSERT INTO SERVICE VALUES(7, 'Airport Transfers','Transportation','C');
INSERT INTO SERVICE VALUES(8, 'Care Rentals','Transportation','C');
INSERT INTO SERVICE VALUES(9, 'Chauffeur Services','Transportation','C');

INSERT INTO SERVICE VALUES(10, 'Breakfast Buffet (1)','Buffet','K');
INSERT INTO SERVICE VALUES(11, 'Lunch Buffet (1)','Buffet','K');
INSERT INTO SERVICE VALUES(12, 'Dinner Buffet (1)','Buffet','K');
INSERT INTO SERVICE VALUES(13, 'In-room dining','Meals','K');
INSERT INTO SERVICE VALUES(14, 'Breakfast','Meals','K');
INSERT INTO SERVICE VALUES(15, 'Lunch','Meals','K');
INSERT INTO SERVICE VALUES(16, 'Dinner','Meals','K');
INSERT INTO SERVICE VALUES(17, 'Bar and Lounge','Meals','K');
INSERT INTO SERVICE VALUES(18, 'Garden Tea Party (1)','Meals','K');

INSERT INTO SERVICE VALUES(19, 'Room Cleaning','Other Offers','H');
INSERT INTO SERVICE VALUES(20, 'Laundry Services','Other Offers','H');
INSERT INTO SERVICE VALUES(21, 'Maintenance','Other Offers','H');
INSERT INTO SERVICE VALUES(22, 'Restocking Amenities','','H');
INSERT INTO SERVICE VALUES(23, 'In Room Chips','In Room Snacks','H');
INSERT INTO SERVICE VALUES(24, 'In Room Soda','In Room Snacks','H');
INSERT INTO SERVICE VALUES(25, 'In Room Sparkling Water','In Room Snacks','H');
INSERT INTO SERVICE VALUES(26, 'In Room Chocolates','In Room Snacks','H');

INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 1, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 2, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 3, '2000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 4, '5000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 5, '2000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 6, '3000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 7, '2500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 8, '2500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 9, '1800');

INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 10, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 11, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 12, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 13, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 14, '500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 15, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 16, '1000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 17, '1000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 18, '1500');

INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 19, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 20, '500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 21, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 22, '300');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 23, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 24, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 25, '80');
INSERT INTO SERVICE_ROOM_TYPE VALUES(1, 26, '200');

INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 1, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 2, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 3, '2000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 4, '5000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 5, '2000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 6, '3000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 7, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 8, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 9, '0');

INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 10, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 11, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 12, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 13, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 14, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 15, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 16, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 17, '1000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 18, '1500');

INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 19, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 20, '500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 21, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 22, '300');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 23, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 24, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 25, '80');
INSERT INTO SERVICE_ROOM_TYPE VALUES(2, 26, '200');

INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 1, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 2, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 3, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 4, '5000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 5, '2000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 6, '3000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 7, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 8, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 9, '0');

INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 10, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 11, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 12, '1800');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 13, '1500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 14, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 15, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 16, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 17, '1000');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 18, '1500');

INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 19, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 20, '500');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 21, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 22, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 23, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 24, '150');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 25, '80');
INSERT INTO SERVICE_ROOM_TYPE VALUES(3, 26, '200');

INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 1, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 2, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 3, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 4, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 5, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 6, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 7, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 8, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 9, '0');

INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 10, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 11, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 12, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 13, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 14, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 15, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 16, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 17, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 18, '0');

INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 19, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 20, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 21, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 22, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 23, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 24, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 25, '0');
INSERT INTO SERVICE_ROOM_TYPE VALUES(4, 26, '0');

CREATE SEQUENCE GUEST_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE  CHARGE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE  SERVICE_LINE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE  PAYMENT_SEQ
START WITH 1
INCREMENT BY 1;

SELECT * FROM SERVICE;

-- SELECT R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA
-- FROM ROOM R LEFT JOIN ROOM_TYPE RT on R.ROOM_TYPE = RT.ROOM_TYPE
--             LEFT JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
--             LEFT JOIN BRN B ON C.BRN_ID = B.BRN_ID
-- WHERE R.ROOM_NUMBER NOT IN (SELECT R.ROOM_NUMBER
--                             FROM ROOM R JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
--                                         JOIN BRN B ON C.BRN_ID = B.BRN_ID
--                             WHERE B.BRN_ID NOT IN (SELECT BRN_ID FROM BRN WHERE STATUS = 'CHECKED-OUT')
--                             GROUP BY R.ROOM_NUMBER)
-- GROUP BY R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA
--
-- SELECT R.ROOM_NUMBER, B.BRN_ID
-- FROM ROOM R JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER
--             JOIN BRN B ON C.BRN_ID = B.BRN_ID
-- WHERE STATUS != 'CHECKED-OUT';
--
-- SELECT G.FIRST_NAME, G.MIDDLE_NAME, G.LAST_NAME
-- FROM GUEST G JOIN BRN B ON G.BRN_ID = B.BRN_ID
-- WHERE G.BRN_ID = ?1 AND GUEST_TYPE = 'P';
--
-- SELECT SERVICE_NAME, PRICE, SERVICE_DATE
-- FROM SERVICE    JOIN SERVICE_LINE SL ON SERVICE.SERVICE_ID = SL.SERVICE_ID
--                 JOIN CHARGE C ON SL.CHARGE_ID = C.CHARGE_ID
--                 JOIN ROOM R ON C.ROOM_NUMBER = R.ROOM_NUMBER
--                 JOIN BRN B ON C.BRN_ID = B.BRN_ID
--                 JOIN SERVICE_ROOM_TYPE SRT on SERVICE.SERVICE_ID = SRT.SERVICE_ID
-- WHERE C.ROOM_NUMBER = ?1 AND C.BRN_ID = ?2 AND EMPLOYEE_TYPE = ?3;
--
-- SELECT BRN_ID
-- FROM BRN
-- WHERE STATUS != 'CHECKED-OUT';
--
-- SELECT ROOM_NUMBER
-- FROM CHARGE
-- WHERE BRN_ID = ?1;
--
-- SELECT E.EMPLOYEE_ID, E.EMPLOYEE_TYPE
-- FROM EMPLOYEE E JOIN ACCOUNTS A on E.EMPLOYEE_ID = A.EMPLOYEE_ID
-- WHERE A.EMAIL = ?1 AND A.PASSWORD = ?2;
--
-- SELECT RT.PRICE
-- FROM ROOM_TYPE RT JOIN ROOM R ON RT.ROOM_TYPE = R.ROOM_TYPE
-- WHERE R.ROOM_NUMBER = ?1;

commit;

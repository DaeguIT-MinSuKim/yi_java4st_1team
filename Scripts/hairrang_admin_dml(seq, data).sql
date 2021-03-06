CREATE SEQUENCE GUEST_SEQ
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE GUEST_SEQ;

INSERT INTO GUEST
VALUES(1, '이지수', TO_DATE('1900-01-02', 'YYYY-MM-DD'), SYSDATE, '010-1234-5678', 2, NULL);
	
SELECT *
FROM GUEST;

DELETE FROM GUEST;

INSERT INTO GUEST
VALUES(2, '김대훈', TO_DATE('1900-12-01', 'YYYY-MM-DD'), SYSDATE, '010-4321-8765', 1, NULL);

INSERT INTO HAIR VALUES (1,'커트',3000);
INSERT INTO HAIR VALUES (2,'염색',5000);

SELECT * FROM HAIR;

SELECT HAIR_NO ,HAIR_NAME ,PRICE FROM HAIR;

INSERT INTO EVENT VALUES (1,'생일쿠폰', 0.15);
INSERT INTO EVENT VALUES (2,'1주년', 0.3);

SELECT * FROM EVENT;

INSERT INTO 

INSERT INTO SALES VALUES (1,TO_DATE('2000-12-01','yyyy-mm-dd'),1,1,1);
INSERT INTO SALES VALUES (2,TO_DATE('2000-12-01','yyyy-mm-dd'),2,2,2);
INSERT INTO SALES VALUES (3,TO_DATE('2000-12-01','yyyy-mm-dd'),1,2,1);
INSERT INTO SALES VALUES (4,TO_DATE('2000-12-01','yyyy-mm-dd'),2,2,1);


SELECT * FROM SALES;

SELECT DETAIL_NO , sd.SALES_NO , s.SALES_DAY , s.GUEST_NO ,g.GUEST_NAME  ,h.HAIR_NAME ,h.PRICE  ,e.EVENT_NAME 
	FROM SALES_DETAIL sd JOIN SALES s ON (sd.SALES_NO = s.SALES_NO )
			JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO )
			JOIN HAIR h ON (h.HAIR_NO = sd.HAIR_NO )
			JOIN EVENT e ON (e.EVENT_NO = s.EVENT_NO );
		
		
CREATE OR REPLACE VIEW DETAIL_ALL AS
SELECT DETAIL_NO , sd.SALES_NO , s.SALES_DAY , s.GUEST_NO ,g.GUEST_NAME  ,h.HAIR_NAME ,h.PRICE  ,e.EVENT_NAME 
	FROM SALES_DETAIL sd JOIN SALES s ON (sd.SALES_NO = s.SALES_NO )
			JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO )
			JOIN HAIR h ON (h.HAIR_NO = sd.HAIR_NO )
			JOIN EVENT e ON (e.EVENT_NO = s.EVENT_NO );

SELECT * FROM DETAIL_ALL;
		

INSERT INTO SALES_DETAIL VALUES (1,1,1);
INSERT INTO SALES_DETAIL VALUES (2,1,2);

DELETE FROM SALES_DETAIL;

SELECT * FROM SALES_DETAIL;
--GUEST완



CREATE SEQUENCE SALDETAIL_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE SEQUENCE sales_seq
	START WITH 1
	INCREMENT BY 1;


--INSERT INTO SALES 
--value(sales_seq.nextval, to_date('2020-08-01', 'YYYY-MM-DD'), to_date('2020');



-- sales detail, sales 시퀀스 완



CREATE SEQUENCE EVENT_SEQ
	START WITH 1
	INCREMENT BY 1;
	
CREATE SEQUENCE BOOKING_SEQ
	START WITH 1
	INCREMENT BY 1
	NOCACHE;
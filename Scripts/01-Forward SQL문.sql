/* 고객 */
DROP TABLE hairrang.GUEST 
	CASCADE CONSTRAINTS;

/* 이벤트 */
DROP TABLE hairrang.EVENT 
	CASCADE CONSTRAINTS;

/* 헤어 */
DROP TABLE hairrang.HAIR 
	CASCADE CONSTRAINTS;

/* 주문 */
DROP TABLE hairrang.SALES 
	CASCADE CONSTRAINTS;

/* 예약 */
DROP TABLE hairrang.BOOKING 
	CASCADE CONSTRAINTS;

/* 추가금액 */
DROP TABLE hairrang.TABLE 
	CASCADE CONSTRAINTS;

/* 주문상세 */
DROP TABLE hairrang.SALES_DETAIL 
	CASCADE CONSTRAINTS;

/* 고객 */
CREATE TABLE hairrang.GUEST (
	guest_no NUMBER(10) NOT NULL, /* 고객번호 */
	guest_name VARCHAR2(20) NOT NULL, /* 고객명 */
	birthday DATE, /* 생년월일 */
	join_day DATE NOT NULL, /* 가입일자 */
	phone VARCHAR2(13) NOT NULL, /* 전화번호 */
	gender NUMBER(1) NOT NULL, /* 성별 */
	guest_note VARCHAR2 /* 고객비고 */
);

CREATE UNIQUE INDEX hairrang.PK_GUEST
	ON hairrang.GUEST (
		guest_no ASC
	);

ALTER TABLE hairrang.GUEST
	ADD
		CONSTRAINT PK_GUEST
		PRIMARY KEY (
			guest_no
		);

/* 이벤트 */
CREATE TABLE hairrang.EVENT (
	event_no NUMBER(10) NOT NULL, /* 이벤트번호 */
	event_name VARCHAR2(20) NOT NULL, /* 이벤트명 */
	sale NUMBER(0, 2) NOT NULL /* 할인율 */
);

CREATE UNIQUE INDEX hairrang.PK_EVENT
	ON hairrang.EVENT (
		event_no ASC
	);

ALTER TABLE hairrang.EVENT
	ADD
		CONSTRAINT PK_EVENT
		PRIMARY KEY (
			event_no
		);

/* 헤어 */
CREATE TABLE hairrang.HAIR (
	hair_no NUMBER(10) NOT NULL, /* 헤어번호 */
	hair_name VARCHAR2(20) NOT NULL, /* 헤어명 */
	price NUMBER NOT NULL /* 단가 */
);

CREATE UNIQUE INDEX hairrang.PK_HAIR
	ON hairrang.HAIR (
		hair_no ASC
	);

ALTER TABLE hairrang.HAIR
	ADD
		CONSTRAINT PK_HAIR
		PRIMARY KEY (
			hair_no
		);

/* 주문 */
CREATE TABLE hairrang.SALES (
	sales_no NUMBER(10) NOT NULL, /* 영업번호 */
	sales_day DATE NOT NULL, /* 영업일자 */
	guest_no NUMBER(10), /* 고객번호 */
	event_no NUMBER(10), /* 이벤트번호 */
	hair_no NUMBER(10) /* 헤어번호 */
);

CREATE UNIQUE INDEX hairrang.PK_SALES
	ON hairrang.SALES (
		sales_no ASC
	);

ALTER TABLE hairrang.SALES
	ADD
		CONSTRAINT PK_SALES
		PRIMARY KEY (
			sales_no
		);

/* 예약 */
CREATE TABLE hairrang.BOOKING (
	book_no NUMBER(10) NOT NULL, /* 예약번호 */
	guest_no NUMBER(10), /* 고객번호 */
	book_date DATE NOT NULL, /* 예약 */
	hair_no NUMBER(10), /* 헤어번호 */
	book_note <지정 되지 않음> /* 예약비고 */
);

CREATE UNIQUE INDEX hairrang.PK_BOOKING
	ON hairrang.BOOKING (
		book_no ASC
	);

ALTER TABLE hairrang.BOOKING
	ADD
		CONSTRAINT PK_BOOKING
		PRIMARY KEY (
			book_no
		);

/* 추가금액 */
CREATE TABLE hairrang.TABLE (
	COL NUMBER(10) NOT NULL, /* 기장코드 */
	COL2 NUMBER /* 기장금액 */
);

CREATE UNIQUE INDEX hairrang.PK_TABLE
	ON hairrang.TABLE (
		COL ASC
	);

ALTER TABLE hairrang.TABLE
	ADD
		CONSTRAINT PK_TABLE
		PRIMARY KEY (
			COL
		);

/* 주문상세 */
CREATE TABLE hairrang.SALES_DETAIL (
	detail_no NUMBER(10) NOT NULL, /* 소영업번호 */
	sales_no NUMBER(10) NOT NULL, /* 영업번호 */
	hair_no NUMBER(10) /* 헤어번호 */
);

CREATE UNIQUE INDEX hairrang.PK_SALES_DETAIL
	ON hairrang.SALES_DETAIL (
		detail_no ASC
	);

ALTER TABLE hairrang.SALES_DETAIL
	ADD
		CONSTRAINT PK_SALES_DETAIL
		PRIMARY KEY (
			detail_no
		);

ALTER TABLE hairrang.SALES
	ADD
		CONSTRAINT FK_GUEST_TO_SALES
		FOREIGN KEY (
			guest_no
		)
		REFERENCES hairrang.GUEST (
			guest_no
		);

ALTER TABLE hairrang.SALES
	ADD
		CONSTRAINT FK_EVENT_TO_SALES
		FOREIGN KEY (
			event_no
		)
		REFERENCES hairrang.EVENT (
			event_no
		);

ALTER TABLE hairrang.SALES
	ADD
		CONSTRAINT FK_HAIR_TO_SALES
		FOREIGN KEY (
			hair_no
		)
		REFERENCES hairrang.HAIR (
			hair_no
		);

ALTER TABLE hairrang.BOOKING
	ADD
		CONSTRAINT FK_GUEST_TO_BOOKING
		FOREIGN KEY (
			guest_no
		)
		REFERENCES hairrang.GUEST (
			guest_no
		);

ALTER TABLE hairrang.BOOKING
	ADD
		CONSTRAINT FK_HAIR_TO_BOOKING
		FOREIGN KEY (
			hair_no
		)
		REFERENCES hairrang.HAIR (
			hair_no
		);

ALTER TABLE hairrang.SALES_DETAIL
	ADD
		CONSTRAINT FK_SALES_TO_SALES_DETAIL
		FOREIGN KEY (
			sales_no
		)
		REFERENCES hairrang.SALES (
			sales_no
		);

ALTER TABLE hairrang.SALES_DETAIL
	ADD
		CONSTRAINT FK_HAIR_TO_SALES_DETAIL
		FOREIGN KEY (
			hair_no
		)
		REFERENCES hairrang.HAIR (
			hair_no
		);
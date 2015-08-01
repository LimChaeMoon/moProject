
/* Drop Tables */

DROP TABLE movie_booking CASCADE CONSTRAINTS;
DROP TABLE movie_info CASCADE CONSTRAINTS;
DROP TABLE tab_user CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE movie_booking
(
	res_seat_num number NOT NULL,
	user_id varchar2(20) NOT NULL,
	movie_no number NOT NULL,
	pay_type number
);


CREATE TABLE movie_info
(
	movie_name varchar2(30) NOT NULL,
	screen_num varchar2(10) NOT NULL,
	seat_amount number NOT NULL,
	price number NOT NULL,
	movie_no number NOT NULL,
	movie_time date NOT NULL,
	PRIMARY KEY (movie_no)
);


CREATE TABLE tab_user
(
	user_id varchar2(20) NOT NULL,
	user_name varchar2(20) NOT NULL,
	user_pwd varchar2(100) NOT NULL,
	user_pwd_hint varchar2(200) NOT NULL,
	user_pwd_answer varchar2(100) NOT NULL,
	user_gender number(1) DEFAULT 1 NOT NULL,
	user_email varchar2(60),
	user_phone varchar2(16),
	user_zipcode varchar2(7) NOT NULL,
	user_addr1 varchar2(100) NOT NULL,
	user_addr2 varchar2(50) NOT NULL,
	user_regdate date DEFAULT sysdate NOT NULL,
	user_lastip varchar2(30),
	user_level number(3) DEFAULT 0 NOT NULL,
	user_status number(1) DEFAULT 0 NOT NULL,
	PRIMARY KEY (user_id)
);



/* Create Foreign Keys */

ALTER TABLE movie_booking
	ADD FOREIGN KEY (movie_no)
	REFERENCES movie_info (movie_no)
;


ALTER TABLE movie_booking
	ADD FOREIGN KEY (user_id)
	REFERENCES tab_user (user_id)
;




DROP SEQUENCE MOVIE_INFO_MOVIE_NO.NEXTVAL;

CREATE SEQUENCE MOVIE_INFO_MOVIE_NO
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 10000
NOCACHE
NOCYCLE



INSERT INTO MOVIE_INFO (movie_name,screen_num, 
	movie_time, seat_amount, price, movie_no) VALUES ('미션임파서블 로그네이션',
	'4관', TO_DATE('08-01-2015 09:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);


INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'4관', TO_DATE('08-01-2015 11:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'4관', TO_DATE('08-01-2015 14:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'4관', TO_DATE('08-01-2015 17:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount, price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'4관', TO_DATE('08-01-2015 19:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'3관', TO_DATE('08-01-2015 09:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'3관', TO_DATE('08-01-2015 12:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'3관', TO_DATE('08-01-2015 17:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'3관', TO_DATE('08-01-2015 22:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'5관', TO_DATE('08-01-2015 10:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'5관', TO_DATE('08-01-2015 13:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'5관', TO_DATE('08-01-2015 15:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'5관', TO_DATE('08-01-2015 18:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'5관', TO_DATE('08-01-2015 21:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'2관', TO_DATE('08-01-2015 13:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'2관', TO_DATE('08-01-2015 16:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'2관', TO_DATE('08-01-2015 19:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'2관', TO_DATE('08-01-2015 21:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미션임파서블 로그네이션', 
	'7관', TO_DATE('08-01-2015 20:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('인사이드아웃', 
	'6관', TO_DATE('08-01-2015 08:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('인사이드아웃', 
	'2관', TO_DATE('08-01-2015 11:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('인사이드아웃', 
	'7관', TO_DATE('08-01-2015 17:45:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'7관', TO_DATE('08-01-2015 09:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'7관', TO_DATE('08-01-2015 12:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'7관', TO_DATE('08-01-2015 14:50:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

	INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'8관', TO_DATE('08-01-2015 08:50:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'8관', TO_DATE('08-01-2015 12:40:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'8관', TO_DATE('08-01-2015 15:30:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'8관', TO_DATE('08-01-2015 18:25:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'8관', TO_DATE('08-01-2015 21:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'1관', TO_DATE('08-01-2015 10:30:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'1관', TO_DATE('08-01-2015 13:20:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'1관', TO_DATE('08-01-2015 16:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);

INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'1관', TO_DATE('08-01-2015 19:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'1관', TO_DATE('08-01-2015 22:05:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'6관', TO_DATE('08-01-2015 11:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'6관', TO_DATE('08-01-2015 14:05:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'6관', TO_DATE('08-01-2015 16:55:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('암살', 
	'6관', TO_DATE('08-01-2015 20:00:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미니언즈', 
	'2관', TO_DATE('08-01-2015 08:10:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);
	
INSERT INTO MOVIE_INFO (movie_name, screen_num, 
	movie_time, seat_amount,price, movie_no) VALUES ('미니언즈', 
	'3관', TO_DATE('08-01-2015 20:25:00', 'MM-DD-YYYY HH24:MI:SS'), 36, 5000, MOVIE_INFO_MOVIE_NO.NEXTVAL);



SELECT movie_name, screen_num, movie_time, 
 seat_amount, price, movie_no FROM MOVIE_INFO 
 WHERE movie_name = '미션임파서블 로그네이션'
 AND movie_time >= SYSDATE-2/24 
 AND movie_time <= SYSDATE+10/24
 ORDER BY movie_time ASC;
 
 
 SELECT b.res_seat_num FROM movie_info i, movie_booking b
 WHERE i.movie_no = b.movie_no AND i.movie_no = 51;
 
 
 SELECT screen_num, price, movie_time FROM movie_info WHERE movie_no = ?
 
 
 
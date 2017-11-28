select * from tab;

drop table tb_member purge;

CREATE TABLE tb_member (
    member_no  NUMBER(10)      PRIMARY KEY
 ,  id         VARCHAR2(20)    NOT NULL
 ,  password   VARCHAR2(20)    NOT NULL
 ,  email      VARCHAR2(20)    NOT NULL
 ,  name       VARCHAR2(20)    NOT NULL
 ,  birth      DATE            NOT NULL
 ,  calender   NUMBER(3)       NOT NULL
 ,  birth_time VARCHAR2(20)    NOT NULL
 ,  gender     NUMBER(2)       NOT NULL
 ,  question   VARCHAR2(20)    NOT NULL
 ,  answer     VARCHAR2(20)    NOT NULL

 );
 
 CREATE TABLE tb97_member (
    member_no  NUMBER(10)      PRIMARY KEY
 ,  id         VARCHAR2(20)    NOT NULL
 ,  password   VARCHAR2(20)    NOT NULL
 ,  email      VARCHAR2(20)    NOT NULL
 ,  name       VARCHAR2(20)    NOT NULL
 ,  birth      DATE            NOT NULL
 ,  calender   NUMBER(3)       NOT NULL
 ,  birth_time VARCHAR2(20)    NOT NULL
 ,  gender     NUMBER(2)       NOT NULL
 ,  question   VARCHAR2(20)    NOT NULL
 ,  answer     VARCHAR2(20)    NOT NULL
 
 );
 CREATE TABLE tb97_Board (
 	board_no number(10) primary key,
 	member_no number(10) not null,
 	title varchar2(100) not null,
 	writer varchar2(100) not null,
 	content varchar2(4000) not null,
 	reg_Date date default sysdate,
 	files varchar2(300),
 	table_type number(1) not null,
 	address varchar(1000)
 );
 create table tb97_comment(
 	board_no number(10) not null,
 	member_no number(10) not null,
 	comment_no number(10) not null,
 	content varchar(100) not null
 );
 create table tb97_qna(
 	qna_no number(10) primary key,
 	title varchar2(100) not null,
 	writer varchar2(100) not null,
 	content varchar2(4000) not null,
 	reg_date date default sysdate,
 	member_no number(10) not null
 );
  create table tb97_info(
 	star_content varchar2(4000) not null,
 	zodiac_content varchar2(4000) not null,
 	drink_name varchar2(50),
 	drink_content varchar2(4000),
 	photo varchar2(300),
 	reg_date date default sysdate,
 	member_no number(10) not null
 );
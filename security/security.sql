-- 회원정보 테이블
create table sp_user(
	userid varchar2(50),
	email varchar2(100) not null,
	enabled char(1) default '1',
	password varchar2(100) not null
);

alter table sp_user add constraint sp_user_pk primary key(userid);

-- 권한 테이블
create table sp_user_authority(
	userid varchar2(50) not null,
	authority varchar2(50) not null
);

alter table sp_user_authority add constraint sp_user_authority_fk foreign key(userid)
references sp_user(userid);

insert into sp_user(userid,email,password) values('1','user@test.com','1111');
insert into sp_user_authority(userid,authority) values('1','ROLE_USER');
insert into sp_user_authority(userid,authority) values('1','ROLE_ADMIN');

select * from SP_USER;

-- 권한 가져오기
select * from SP_USER_AUTHORITY where userid='1';

-- 조인
-- 내부 조인 : 일치하는 컬럼 기준으로 값 가져오기
-- 외부 조인(left outer join, right outer join)

select s1.userid,email,password,enabled,authority
from SP_USER s1 join SP_USER_AUTHORITY s2 on s1.userid = s2.userid
where s1.userid='1';

select * from SP_USER;
select * from SP_USER_AUTHORITY;

insert into sp_user(userid,email,password) values('admin','admin@test.com','123123');
insert into sp_user_authority(userid,authority) values('admin','ROLE_USER');
insert into sp_user_authority(userid,authority) values('admin','ROLE_ADMIN');

-- 로그인 기억하기 테이블 : 이건 꼭 이 형태로 만들어야 함 정의되어 있음 이렇게
create table persistent_logins(
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);

select * from persistent_logins;
CREATE TABLE Student 
(
no int(50) not null PRIMARY key, -- 学号
name VARCHAR(50) not null, -- 学生姓名
sex VARCHAR(50) not null, -- 性别
birthday VARCHAR(50) not null, -- 生日
class VARCHAR(50) not null -- 班级
)
CREATE TABLE Teacher 
(
no int(50) not null PRIMARY key, -- 教师编号
name VARCHAR(50) not null, -- 教师姓名
 sex VARCHAR(50) not null, -- 教师性别
 birthday datetime, -- 教师生日
 prof VARCHAR(50) not null, -- 职位
 depart VARCHAR(50) not null -- 系别
)
CREATE TABLE Course 
(
cno VARCHAR(50) not null PRIMARY key, -- 课程编号
cname VARCHAR(50) not null, -- 课程
 tno int(50) not null -- 教师编号
)
CREATE TABLE Score 
(
no int(50) not null , -- 学号
cno VARCHAR(50) not null, -- 课程编号
degree int(50) not null -- 成绩
)
DROP TABLE Score;
INSERT INTO course VALUES ('3-101','数据库',1);
INSERT INTO course VALUES ('5-102','数学',3);
INSERT INTO course VALUES ('3-103','信息系统',4);
INSERT INTO course VALUES ('3-104','操作系统',6);
INSERT INTO course VALUES ('3-105','数据结构',4);
INSERT INTO course VALUES ('3-106','数据处理',5);
INSERT INTO course VALUES ('4-107','pascal语言',5);
INSERT INTO course VALUES ('4-108','c++',7);
INSERT INTO course VALUES ('4-109','java',8);
INSERT INTO course VALUES ('3-245','数据挖掘',10);
INSERT INTO course VALUES ('3-111','软件工程',11);

INSERT INTO score VALUES(5001,'3-105',69);
INSERT INTO score VALUES(5001,'5-102',55);
INSERT INTO score VALUES(5003,'4-108',85);
INSERT INTO score VALUES(5004,'3-105',77);
INSERT INTO score VALUES(5005,'3-245',100);
INSERT INTO score VALUES(5006,'3-105',53);
INSERT INTO score VALUES(5003,'4-109',45);
INSERT INTO score VALUES(5008,'3-105',98);
INSERT INTO score VALUES(5004,'4-109',68);
INSERT INTO score VALUES(5010,'3-105',88);
INSERT INTO score VALUES(5003,'3-105',98);
INSERT INTO score VALUES(5005,'4-109',68);
INSERT INTO score VALUES(5002,'3-105',88);
INSERT INTO score VALUES(107,'3-105',98);
INSERT INTO score VALUES(108,'4-109',68);
INSERT INTO score VALUES(109,'3-105',88);
INSERT INTO score VALUES(109,'4-109',80);
INSERT INTO score VALUES(107,'3-111',88);
INSERT INTO score VALUES(5003,'3-111',80);


INSERT INTO Student VALUES(5001,'李勇','男','1987-7-22','95001');
INSERT INTO Student VALUES(5002,'刘晨','女','1987-11-15','95002');
INSERT INTO Student VALUES(5003,'王敏','女','1998-10-5','95001');
INSERT INTO Student VALUES(5004,'李好尚','男','1987-9-25','95003');
INSERT INTO Student VALUES(5005,'李军','男','1987-7-17','95004');
INSERT INTO Student VALUES(5006,'范新位','女','1987-6-18','95005');
INSERT INTO Student VALUES(5007,'张霞东','女','1987-8-29','95006');
INSERT INTO Student VALUES(5008,'赵薇','男','1987-6-15','95007');
INSERT INTO Student VALUES(5009,'钱民将','女','1987-6-23','95008');
INSERT INTO Student VALUES(5010,'孙俪','女','1987-9-24','95002');
INSERT INTO Student VALUES(108,'赵里','男','1987-6-15','95007');
INSERT INTO Student VALUES(109,'丘处机','男','1987-6-23','95008');
INSERT INTO Student VALUES(107,'杨康','男','1987-9-24','95001');


INSERT INTO Teacher VALUES(1,'李卫','男','1957-11-5','教授','电子工程系');
INSERT INTO Teacher VALUES(2,'刘备','男','1967-10-9','副教授','math');
INSERT INTO Teacher VALUES(3,'关羽','男','1977-9-20','讲师','sc');
INSERT INTO Teacher VALUES(4,'李修','男','1957-6-25','教授','elec');
INSERT INTO Teacher VALUES(5,'诸葛亮','男','1977-6-15','教授','计算机系');
INSERT INTO Teacher VALUES(6,'殷素素','女','1967-1-5','副教授','sc');
INSERT INTO Teacher VALUES(7,'周芷若','女','1947-2-3','教授','sc');
INSERT INTO Teacher VALUES(8,'赵云','男','1980-6-13','副教授','计算机系');
INSERT INTO Teacher VALUES(9,'张敏','女','1985-5-5','助教','sc');
INSERT INTO Teacher VALUES(10,'黄蓉','女','1967-3-22','副教授','sc');
INSERT INTO Teacher VALUES(11,'张三','男','1967-3-22','副教授','sc');



-- 以class降序输出student的所有记录（student表全部属性）
SELECT * FROM student ORDER BY class;

-- 列出教师所在的单位depart（不重复）
SELECT DISTINCT depart FROM teacher;

-- 列出student表中所有记录的name、sex和class列
SELECT
	NAME,
	sex,
	class
FROM student

-- 输出student中不姓王的同学的姓名。
SELECT NAME FROM student WHERE NAME NOT LIKE '王%'

-- 输出成绩为85或86或88或在60-80之间的记录（no,cno,degree）
SELECT * FROM score WHERE (degree BETWEEN 60 AND 80) OR degree IN(85,86);

-- 输出班级为95001或性别为‘女’ 的同学（student表全部属性）
SELECT * FROM student WHERE class = 95001 OR sex = '女';

-- 输出男生人数及这些男生分布在多少个班级中
SELECT
	COUNT(NAME) AS 男生人数,
	COUNT(class) AS 班级个数
FROM student
WHERE sex='男';

-- 列出存在有85分以上成绩的课程编号。
SELECT DISTINCT cno AS 课程编号 FROM score WHERE degree > 85;
	
-- 输出95001班级的学生人数
SELECT COUNT(NAME) AS 95001班级人数 FROM student WHERE class = 95001;
 
-- 输出‘3-105’号课程的平均分
SELECT AVG(degree) FROM score WHERE cno = '3-105';
 
-- 输出student中最大和最小的birthday日期值
SELECT MAX(birthday),MIN(birthday) FROM student;

-- 显示95001和95004班全体学生的全部个人信息（不包括选课）。（student表全部属性）
SELECT * FROM student WHERE class IN(95001,95004);

-- 输出至少有5个同学选修的并以3开头的课程的课程号，课程平均分，课程最高分，课程最低分。
SELECT
	cno,	-- 课程号
	AVG(degree),	-- 课程平均分
	MAX(degree),	-- 课程最高分
	MIN(degree) 	-- 课程最低分
FROM score 
WHERE cno LIKE '3%' 
GROUP BY cno 
HAVING COUNT(cno)>=5;

-- 输出所选修课程中最低分大于70分且最高分小于90分的学生学号及学生姓名
	-- 获取符合条件的学生学号
	SELECT NO FROM score GROUP BY NO HAVING MAX(degree)<90 AND MIN(degree)>70;
	-- 根据学号找到学生姓名
	SELECT
		NO,
		NAME
	FROM student
	WHERE NO IN(SELECT NO FROM score GROUP BY NO HAVING MAX(degree)<90 AND MIN(degree)>70);
		
-- 显示所教课程选修人数多于5人的教师姓名
	-- 获取选修人数多于5人的课程编号
	SELECT cno FROM score GROUP BY cno HAVING COUNT(NO)>5;
	-- 获取课程编号对应的教师编号
	SELECT tno FROM course WHERE cno IN(SELECT cno FROM score GROUP BY cno HAVING COUNT(NO)>5);
	-- 根据教师编号查找姓名
	SELECT NAME FROM teacher WHERE NO IN(
		SELECT tno 
		FROM course 
		WHERE cno IN(
			SELECT cno 
			FROM score 
			GROUP BY cno 
			HAVING COUNT(NO)>5
		)
	);
	
-- 输出’95001’班级所选课程的课程号和平均分
	-- 找出95001课程的学生编号
	SELECT NO FROM student WHERE class=95001;
	-- 根据学生编号筛选
	SELECT
		*
	FROM score
	WHERE NO IN (SELECT NO FROM student WHERE class=95001);
	-- 根据临时表格求平均
	SELECT
		t1.cno,
		AVG(degree)
	FROM (SELECT NO,cno,degree FROM score WHERE NO IN (SELECT NO FROM student WHERE class=95001)) t1
	GROUP BY cno;

-- 输出至少有两名男同学的班级编号
SELECT class FROM student GROUP BY sex HAVING COUNT(NO)>=2;


-- 列出存在有85分以上成绩的课程名称
SELECT DISTINCT cno FROM score WHERE degree>85;
SELECT cname FROM course WHERE cno IN(SELECT DISTINCT cno FROM score WHERE degree>85);

-- 列出“计算机系”教师所教课程的成绩表（课程编号，课程名，学生名，成绩）。
	-- 找教师编号
	SELECT NO FROM teacher WHERE depart = '计算机系';
	-- 查找课程编号,课程名称
	SELECT cno,cname FROM course WHERE tno IN(SELECT NO FROM teacher WHERE depart = '计算机系');
	-- 找学生编号,成绩
	SELECT
		t2.`cno`,	-- 课程编号
		t2.cname,	-- 课程名
		t1.no,		-- 学生编号
		t1.`degree`	-- 成绩
	FROM 	score t1,
		(SELECT cno,cname FROM course WHERE tno IN(SELECT NO FROM teacher WHERE depart = '计算机系')) t2
	WHERE t1.`cno`=t2.cno;
	
	-- 找学生姓名
	SELECT
		t1.cno,
		t1.cname,
		t2.`name`,
		t1.degree
	FROM 	student t2,
		(SELECT
			t2.`cno`,	-- 课程编号
			t2.cname,	-- 课程名
			t1.no,		-- 学生编号
			t1.`degree`	-- 成绩
		FROM 	score t1,
			(SELECT cno,cname FROM course WHERE tno IN(SELECT NO FROM teacher WHERE depart = '计算机系')) t2
		WHERE t1.`cno`=t2.cno) t1
	WHERE t1.no=t2.`no`;
	
	
-- 显示‘张三’教师任课的学生姓名，课程名，成绩
	-- 找教师编号
	SELECT NO FROM teacher WHERE NAME = '张三';
	
	-- 找[课程名称]和课程编号
	SELECT cno,cname FROM course WHERE tno=(SELECT NO FROM teacher WHERE NAME = '张三');
	
	-- 根据课程编号找学生编号
	SELECT
		t1.`no`,
		t2.cname,
		t1.`degree`
	FROM 	score t1,
		(SELECT cno,cname FROM course WHERE tno=(SELECT NO FROM teacher WHERE NAME = '张三')) t2
	WHERE t1.`cno`=t2.cno;
		
	-- 根据课程编号找[学生姓名]和[成绩]
	SELECT
		t1.`name`,
		t2.cname,
		t2.degree
	FROM 	student t1,
		(SELECT
			t1.`no`,	-- 学生编号
			t2.cname,	-- 课程名
			t1.`degree`	-- 分数
		FROM 	score t1,
			(SELECT cno,cname FROM course WHERE tno=(SELECT NO FROM teacher WHERE NAME = '张三')) t2
		WHERE t1.`cno`=t2.cno
		) t2
	WHERE t1.`no`=t2.no;
	

-- 列出所讲课已被选修的教师的姓名和系别
	-- 根据score查找已被选修的课程编号
	SELECT DISTINCT cno FROM score;
	-- 根据课程编号找出教师编号
	SELECT tno FROM course WHERE cno IN (SELECT DISTINCT cno FROM score);
	-- 根据教师编号找出教师姓名和系别
	SELECT NAME,depart FROM teacher WHERE NO IN(SELECT tno FROM course WHERE cno IN (SELECT DISTINCT cno FROM score));
	
-- 输出所有学生的name、no和degree。
	-- 查找学生的[name],[no]
	SELECT NO,NAME FROM student;
	-- 根据学生no 查找 [degree]
	SELECT
		t1.name,
		t1.no,
		t2.`degree`
	FROM 	score t2,
		(SELECT NO,NAME FROM student) t1
	WHERE	t1.no=t2.`no`;
	
-- 列出所有任课教师的name和depart。
SELECT NAME,depart FROM teacher WHERE NO IN(SELECT tno FROM course WHERE cno IN (SELECT DISTINCT cno FROM score));


-- 输出男教师所上课程名称。
	-- 找出男老师教师编号
	SELECT NO FROM teacher WHERE sex = '男';
	-- 根据教师编号查[课程名称]
	SELECT cname FROM course WHERE tno IN (SELECT NO FROM teacher WHERE sex = '男');

-- 出与“李军”同性别的所有同学的name。
	-- 查找李军性别
	SELECT sex FROM student WHERE NAME = '李军';
	-- 根据性别查找name
	SELECT NAME FROM student WHERE sex=(SELECT sex FROM student WHERE NAME = '李军');
 
-- 输出选修“数据结构”课程的男同学的成绩。
	-- 查数据结构课程编号
	SELECT cno FROM course WHERE cname = '数据结构';
	-- 根据课程编号筛选score表并与student表联合查询
	SELECT
		t1.`degree`
	FROM 	score t1,
		student t2
	WHERE t1.`cno` = (SELECT cno FROM course WHERE cname = '数据结构') AND t2.`no`=t1.`no` AND t2.`sex`='男';
 
 
-- 列出选修编号为‘3-105’课程并且该门课程成绩比课程 ‘3-111’的最高分要高的cno,no和degree
	-- 查找3-111最高分
	SELECT
		MAX(degree)
	FROM score
	GROUP BY cno
	HAVING cno='3-111';
	-- 查找报名3-105学生成绩高于max    (AND也可使用having)
	SELECT * FROM score WHERE cno='3-105' AND degree>(SELECT MAX(degree) FROM score GROUP BY cno HAVING cno='3-111');
	
	
-- 输出score中成绩最高的学号和课程号
	-- 求所有学生的最高成绩
	SELECT MAX(degree) FROM score;
	-- 求课程号
	SELECT
		t1.no,
		t1.`cno`
	FROM 	score t1
	WHERE t1.degree=(SELECT MAX(degree) FROM score);
 
-- 输出选修3-105课程，其成绩高于109号同学在此课程所得成绩的所有同学的学号，姓名
	-- 109号同学的3-105课程成绩
	SELECT degree FROM score WHERE NO =109 AND cno='3-105';
	-- 选修3-105成绩高于88的学号，姓名
	SELECT
		t1.`no`,
		t2.`name`
	FROM 	score t1,
		student t2
	WHERE 	t1.`no`=t2.`no` AND t1.`degree`>(SELECT degree FROM score WHERE NO =109 AND cno='3-105');


-- 列出没有实际授课的教师的姓名和系别
SELECT NAME,depart FROM teacher WHERE NO NOT IN(SELECT tno FROM course WHERE cno IN (SELECT DISTINCT cno FROM score));


-- 列出选修了编号为‘3-105’课程且其成绩高于‘4-109’课程最高成绩的同学的 课程编号，学号和成绩
	-- 查4-109课程最高成绩
	SELECT MAX(degree) FROM score WHERE cno='4-109';
	-- 查选修3-105且成绩高于max
	SELECT
		cno,
		NO,
		degree
	FROM score
	WHERE cno='3-105' AND degree>(SELECT MAX(degree) FROM score WHERE cno='4-109');

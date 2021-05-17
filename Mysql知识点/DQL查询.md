## DQL
> 查询表中数据

#### 1.语法
    select
            字段列表（逗号分隔）
        from
            表名列表
        where
            条件列表
        group by
            分组字段
        having
            分组之后的条件
        order by
            排序
        limit
            分页限定
            

#### 2.基础查询
    1.多个字段
        SELECT name, --姓名
                age  --年龄
        FROM student;
    2.去重
        select distinct name,address from student
        
        注意：
            结果集一样才能合并
    3.计算列
        select math+english from stdent;
        
        注意：
            如果为null,计算为null
        
        解决：
            select math+ IFNULL(english,0) from student
    
    4.给查询结果起别名
       select math+ IFNULL(english,0) as "总分" from student
       加不加引号都可以

#### 3.条件查询
    >   <   =   <=  >=
    !=      <>
    and     &&
    or      ||
    not     !
    IN(值列表)
    age BETWEN 10 and 20;
    
    select name from student where age<>20;
    判断是否为NULL:
        IS NULL
        IS NOT NULL
        
#### 4.模糊查询
    LIKE
    %   --多个任意字符
    _   --单个任意字符
    
    
    select name from student name like "马%"
    select name from student name like "_马%"
    select * from student name like '___'
    select * from student name like '%马%'
    
#### 5.排序查询
    语法：order by 排序字段1 排序方式1，排序字段2 排序方式2
    
    select * from student order by math
    select * from student order by math DESC--排序方式默认升序
        ASC:升序
        DESC:降序
    
    优先按照数学，英语成绩排名
    selsect * from student order by math ASC,english ASC
    
#### 6.分组查询
    语法：group by 字段
    
    select sex,AVG(math) from student group by sex;
        *结果只能是分组字段 聚合字段（已经分完组了，不存在单个数据）
    
    分数低于70不参与分组
    select sex,AVG(math) from student where math>70 GROUP BY sex;

    分组之后人数大于两个人
    select sex,AVG(math) from student where math>70 GROUP BY sex HAVING COUNT(id)>2
    
        *where:分组之前限定，不满足不参与分组
        *having:分组之后限定，不满足不显示结果，且可以进行聚合函数判断
    
#### 7.分页查询(mysql方言)
    语法：limit 开始的索引，每页查询条数
    
    每页显示3条
    select * from student limit 0,3 --第一页
    select * from student limit 3,3 --第二页
    select * from student limit (n-1)*3,3 --第n页

    
    
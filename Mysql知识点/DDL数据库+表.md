## DDL数据库
#### C(creat)
    1.创建数据库
    creat database 数据库名称;
    
    2.创建db数据库，判断是否存在，并指定字符集为gbk
    creat database if not exists db character set gbk;
#### R(Retrieve)
    1.查询所有数据库名称：
    show databases;
    
    2.查询某个数据库的字符集；查询某个数据库的创建语句
    show creat database 数据库名称;
    
#### U(Update)
    1.修改数据库的字符集
    alter database db character set utf8;
    
#### D(Delete)
    1.删除数据库
    drop database 数据库名称
    
    2.先判断再删除
    drop database if exists;
    
#### 使用数据库
    1. 查询当前正在使用的数据库名称
    select database();
    
    2. 使用指定数据库
    use 数据库名称;


---
---
## DDL表操作
#### C(creat)：创建

    create table 表名(
    列名 数据类型，
    列名 数据类型，
    列名 数据类型
    )；
    最后一行不加逗号
    
    复制一个表    
    create table stu like student;
#### R(Retrieve)：查询

    查询某个数据库中的所有表名称
    show tables; 
    
    查询表结构
    desc 表名

#### U(Update)：修改
    
    修改表名
    alter table 表名 rename to 新的表名
    
    修改表的字符集
    alter table 表名 character set stf8;
    
    添加一列
    alter table 表名 add 列名 数据类型
    
    修改列名称 类型
    alter table 表名 change 旧列名 新列名 新数据类型
    alter table modify 旧列名 新数据类型;
    
    删除列
    alter table 表名 drop 列名
    
#### D(Delete)：删除
    
    删除表
    drop table 表名称
    
    判断删除
    drop table if exists 表名;
    

---


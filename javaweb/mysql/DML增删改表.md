## DML
> 增删改数据
#### 1.添加数据
    insert into stu(id,name,age) VALUES(1,"张无忌",18)
    
    注意：
        1.列名和值一一对应
        2.如果表名不定义列名，默认给所有列添加值
            insert into sudent VALUES(....);
        3.除了数据类型，其他类型需要用引号（单双）
            日期格式：1998-3-19
#### 2.删除数据
    delete from 表名 [where 条件]
    delete from stu where id=1;
    
    注意：
        不写条件默认删除全部记录
        可以使用 truncate table stu 删除表再重新建立一个一模一样的表格（速度快）


​        
#### 3.修改数据
```mssql
update 表名 set 列名1=值1，
                列名2=值2，
                ....
                [where 条件]

UPDATE stu SET age=117 WHERE id=2

注意：
    如果不加任何条件默认修改所有记录
```




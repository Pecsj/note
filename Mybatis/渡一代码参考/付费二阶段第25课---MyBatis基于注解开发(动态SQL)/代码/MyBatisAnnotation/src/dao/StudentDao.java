package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    @Results(
            id="selectStudent",
            value={
                    @Result(property = "sid",column = "sid",id=true),
                    @Result(property = "sname",column = "sname"),
                    @Result(property = "ssex",column = "ssex"),
                    @Result(property = "sage",column = "sage"),
                    @Result(property = "teacherList",javaType = List.class,column = "sid",many = @Many(select="selectTeacher",fetchType = FetchType.LAZY))
            }
    )
    @Select("select * from student where sid = #{sid}")
    //一个带着关联查询的selectOne方法
    public Student selectOne(Integer sid);

    //需要一个辅助方法
    @Select("select t.* from tea_stu ts inner join teacher t on ts.tid = t.tid where ts.sid = #{sid}")
    public Teacher selectTeacher(Integer sid);


    //一个方法 联合查询 所有学生+每个学生对应的所有老师
    @Select("select * from student")
    @ResultMap("selectStudent")
    public List<Student> selectAll();


















    /*
    //设计一个删除单条记录的方法
    @Delete("delete from student where sid = #{sid}")
    void delete(Integer sid);
    //方法的底层有一个代理  帮我们执行这个方法该做的事情
    //分析方法          方法名字delete    方法参数sid
    //分析mapper.xml   类名字dao.StudentDao---namespace
    //                方法名字delete----------id
    //                mapper的<delete>-------SQL语句
    //                语句上面有参数#{key}-----利用方法传递的sid参数进行匹配
    //          代理对象会根据标签<delete>  调用原来sqlSession对象中的delete方法

    //类方法名和sql之间的对应关系  找到sql  知道sql上面的信息  执行哪个方法
    //如果将原有的xml文件删掉 改成注解的形式
    //1.类 方法名和sql对应关系就简单了
    //2.注解中的信息肯定需要写sql
    //3.执行底层的哪个对应方法-----注解名字类似以前的标签名  为了找寻底层方法用的
    //      Insert Delete Update Select

    @Insert("insert into student value (#{sid},#{sname},#{ssex},#{sage})")
    //public void insert(Student student);//一个domain对象 一个基本值(int Integer String)
    //public void insert(Map map);

    public void insert(@Param("sid")Integer sid,@Param("sname")String sname,@Param("ssex")String ssex,@Param("sage")Integer sage);
    //如果dao方法的参数不是包装成一个对象
    //  1.sql中将原来的#{key}---#{param1}  #{param2}
    //  2.方法的每一个参数前面 添加@Param("key")  注解的key与SQL#{key} 对应

    @Update("update student set sname=#{sname},ssex=#{ssex},sage=#{sage} where sid=#{sid}")
    public void update(Student student);


    //==================================================================================

    //dao的方法 负责读取数据库中一行记录
    @Select("select * from student where sid = #{sid}")
    public Student selectOne(Integer sid);
    //接口底层有一个代理类    ProxyStudentDao(对象)
    //ProxyStudentDao代理对象帮我的Dao接口执行一个方法  selectOne
    //  1.解析方法              类名字        方法名字     方法参数        返回值
    //  2.解析mapper.xml文件    namespace   标签中的id   SQL上的#{key}   标签中的resultType
    //      类名字----找寻namespace
    //      方法名字--找寻某一个标签中的id属性
    //          进而找到标签中的一条SQL语句
    //      方法的参数---与找到的SQL进行key匹配  组合成一条完整的SQL语句(可以执行的)
    //          加载驱动
    //          获取连接
    //          获取状态参数啦
    //          拼接SQL
    //          执行查询操作ResultSet = executeQuery();
    //          将结果集的信息取出来  存入一个新的容器内(容器的类型通过解析xml标签中的resultType属性来的)
    //          资源全部关闭
    //          将新的容器连同里面的数据返回

    //  需要的信息 1.类名字 2.方法名字 3.定位注解在哪里 4.注解里获取一条SQL 5.SQL上面的信息(方法参数)
    //           7.执行查询后的返回类型(当前方法的返回值类型) 8.底层执行的方法sqlSession.selectOne();(注解名字)


    //查询多条记录
    @Select("select * from student")
    public List<Student> selectAll();


    //表格之间的关系
    //  一对一
    //  一对多
    //  多对多
    //联合查询
    //  先查一遍  再查一遍(立即加载 延迟加载)
    //  联合的方式(等值连接 内连接 外连接)

    */

}

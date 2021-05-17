package dao;

import domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface StudentDao {

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


}

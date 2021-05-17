package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TeacherDao {

    //根据老师tid   老师信息+学生信息
    @Results(
            id="selectTeacher",
            value={
                    @Result(property = "tid",column = "tid",id=true),
                    @Result(property = "tname",column = "tname"),
                    @Result(property = "tsex",column = "tsex"),
                    @Result(property = "tage",column = "tage"),
                    @Result(property = "studentList",javaType = List.class,column = "tid",many=@Many(select="selectStudent",fetchType = FetchType.LAZY))
            }
    )
    @Select("select * from teacher where tid = #{tid}")
    public Teacher selectOne(Integer tid);

    //辅助方法
    @Select("select s.* from tea_stu ts inner join student s on ts.sid = s.sid where ts.tid = #{tid}")
    public Student selectStudent(Integer tid);


    @Select("select * from teacher")
    @ResultMap("selectTeacher")
    public List<Teacher> selectAll();
}

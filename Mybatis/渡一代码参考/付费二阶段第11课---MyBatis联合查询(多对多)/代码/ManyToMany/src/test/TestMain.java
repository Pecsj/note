package test;

import domain.Student;
import domain.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //测试 根据老师的tid 查询老师信息+这个老师的所有学生信息
//        TeacherService teacherService = new TeacherService();
//        Teacher teacher = teacherService.selectOne(1);
//        System.out.println(teacher);


        //测试 查询所有老师信息+每个老师的所有学生信息
//        TeacherService teacherService = new TeacherService();
//        List<Teacher> teacherList = teacherService.selectAll();
//        for(Teacher t:teacherList){
//            System.out.println(t.getTid()+"--"+t.getTname());
//        }


        //测试 根据学生的sid 查询学生信息+这个学生所学所有老师的信息
//        StudentService studentService = new StudentService();
//        Student student = studentService.selectOne(1);
//        System.out.println(student);


        //测试 查询全部学生的信息+每个学生对应所有老师的信息
        StudentService studentService = new StudentService();
        List<Student> studentList = studentService.selectAll();
        for(Student s:studentList){
            System.out.println(s.getSname());
        }
    }
}

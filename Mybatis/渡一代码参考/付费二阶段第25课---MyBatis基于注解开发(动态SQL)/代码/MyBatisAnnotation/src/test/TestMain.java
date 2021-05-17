package test;

import domain.Emp;
import service.EmpService;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
//        StudentService service = new StudentService();
        //学生删除
        //service.delete(12);

        //新增学生 注册
        //service.regist(new Student(11,"abc","nv",16));

//        Map map = new HashMap();
//        map.put("sid",12);
//        map.put("sname","opq");
//        map.put("ssex","nan");
//        map.put("sage",15);
//        service.regist(map);

//        service.regist(13,"lmn","nan",15);

//        Student student = service.selectOne(10);
//        System.out.println(student);

//        List<Student> studentList = service.selectAll();
//        for(Student s : studentList){
//            System.out.println(s);
//        }

//        PersonService service = new PersonService();
////        Person person = service.selectOne(1);
////        System.out.println(person);
//
//        List<Person> personList = service.selectAll();
//        for(Person p:personList){
//            System.out.println(p);
//        }


//        EmpService service = new EmpService();
////        Emp emp = service.selectOne(7369);
////        System.out.println(emp);
//
//        List<Emp> empList = service.selectAll();
//        System.out.println(empList);


//        DeptService service = new DeptService();
////        Dept dept = service.selectOne(10);
////        System.out.println(dept);
//
//        List<Dept> deptList = service.selectAll();
//        for(Dept d:deptList){
//            System.out.println(d);
//        }


//        StudentService service = new StudentService();
//        Student student = service.selectOne(2);
//        System.out.println(student);

//        List<Student> studentList = service.selectAll();
//        for(Student s : studentList){
//            System.out.println(s);
//        }


//        TeacherService service = new TeacherService();
////        Teacher teacher = service.selectOne(1);
////        System.out.println(teacher);
//        List<Teacher> teacherList = service.selectAll();
//        for(Teacher t:teacherList){
//            System.out.println(t);
//        }

        EmpService service = new EmpService();
//        List<Emp> empList = service.selectEmpsByJobAndDeptno(null,null);
//        for(Emp e:empList){
//            System.out.println(e);
//        }


//        List<Integer> empnos = new ArrayList<Integer>();
//        empnos.add(7369);
//        empnos.add(7788);
//        empnos.add(7902);
//        empnos.add(7876);
//        empnos.add(7654);

        List<Emp> empList = service.selectEmpsByEmpno(7369,7788,7902);
        for(Emp e:empList){
            System.out.println(e);
        }


    }
}

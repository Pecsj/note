package test;

import domain.Student;
import service.StudentService;

public class TestMain {

    public static void main(String[] args) {
        StudentService service = new StudentService();
        Student student = service.selectStudent(1);
        System.out.println(student);
    }
}

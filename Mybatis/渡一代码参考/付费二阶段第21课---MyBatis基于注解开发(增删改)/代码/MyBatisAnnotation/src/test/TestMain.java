package test;

import service.StudentService;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        StudentService service = new StudentService();
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

        service.regist(13,"lmn","nan",15);
    }
}

package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//  <bean id="student" class="domain.Student" scope="singleton" lazy-init="">

@Component("student")
public class Student {

    @Autowired
    @Qualifier("impl2")

    private TestInterface testInterface;
    public TestInterface getTestInterface() {
        return testInterface;
    }

    @Value("1")
    private Integer sid;
    @Value("zzt")
    private String sname;
    @Value("男")
    private String ssex;
    @Value("18")
    private Integer sage;

    public Student() {
        System.out.println("Student对象创建啦");
    }

    public Student(Integer sid, String sname, String ssex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
}

package domain;

public class Student {

    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;

    public Student() {
        System.out.println("Student构造方法");
    }

    public Student(Integer sid, String sname, String ssex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }

    public void init(){
        System.out.println("创建对象同时做的事情");
    }
    public void destroy(){
        System.out.println("销毁对象同时做的事情");
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

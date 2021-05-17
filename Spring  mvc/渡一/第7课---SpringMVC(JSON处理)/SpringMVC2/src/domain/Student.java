package domain;

public class Student {

    private Integer sid;
    private String sname;
    private String ssex;

    public Student() {
    }

    public Student(Integer sid, String sname, String ssex) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                '}';
    }
}

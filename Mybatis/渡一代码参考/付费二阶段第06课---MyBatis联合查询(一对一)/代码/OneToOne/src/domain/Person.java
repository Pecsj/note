package domain;

public class Person {

    //自有属性
    private Integer pid;
    private String pname;
    //关联属性 身份证号(身份证对象中的一个属性)
    private IDCard idcard;

    public Person() {}
    public Person(Integer pid, String pname, IDCard idcard) {
        this.pid = pid;
        this.pname = pname;
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", idcard=" + idcard +
                '}';
    }

    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public IDCard getIdcard() {
        return idcard;
    }
    public void setIdcard(IDCard idcard) {
        this.idcard = idcard;
    }

}

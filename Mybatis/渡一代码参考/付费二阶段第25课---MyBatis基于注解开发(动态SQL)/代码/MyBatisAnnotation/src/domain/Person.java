package domain;

public class Person {

    private Integer pid;
    private String pname;
    private IDCard idCard;//外键  对象 对象的id

    //根据人的pid  查询人的信息+对应的身份证信息


    public Person() {
    }

    public Person(Integer pid, String pname, IDCard idCard) {
        this.pid = pid;
        this.pname = pname;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", idCard=" + idCard +
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

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}

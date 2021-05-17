package domain;

import java.util.List;

public class Dept {

    //自有属性
    private Integer deptno;
    private String dname;
    private String loc;
    //为了通过部门查询到 部门中的所有员工 关联属性
    private List<Emp> empList;


    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc, List<Emp> empList) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", empList=" + empList +
                '}';
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}

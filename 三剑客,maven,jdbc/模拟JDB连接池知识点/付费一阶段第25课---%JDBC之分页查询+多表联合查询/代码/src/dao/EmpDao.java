package dao;

import domain.Dept;
import domain.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EmpDao {

    private String className = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test?useSSL=true";
    private String user = "zzt";
    private String password = "123";
    //Dao层次全都是纯粹的JDBC操作

    //设计一个方法查询 emp中每个部门的人数
    public ArrayList<HashMap<String,Object>> selectCountByGroup(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        String sql = "select deptno,count(empno) as ct from emp group by deptno";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                map.put("deptno",rs.getInt("deptno"));
                map.put("ct",rs.getInt("ct"));
                list.add(map);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }




    //设计一个方法 用来查询所有emp关联dept的数据
//    public ArrayList<Emp> selectAllEmpAndDept(){
//        ArrayList<Emp> list = new ArrayList<Emp>();
//        String sql = "select * from emp e , dept d where e.deptno = d.deptno";
//        try {
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,user,password);
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                Dept dept = new Dept();
//                dept.setDeptno(rs.getInt("deptno"));
//                dept.setDname(rs.getString("dname"));
//                dept.setLoc(rs.getString("loc"));
//                emp.setDept(dept);
//                list.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }









    //设计一个方法 实现分页查询
    //  是否需要参数----> 起始行索引   每页显示几行(Web前端工程师自己规定--5行)
    //  是否需要返回值--> ArrayList<Emp>
//    public ArrayList<Emp> selectByPaging(int rowIndex){
//        ArrayList<Emp> list = new ArrayList<Emp>();
//        String sql = "select * from emp order by sal desc limit ?,5";
//        try {
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,user,password);
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            pstat.setInt(1,rowIndex);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                list.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }









    //设计一个方法 做模糊查询 like
    //使用预处理状态参数 恰巧有动态的问号 遇到了百分号
    //  参数--->字母 A R   返回值--->ArrayList<Emp>
//    public ArrayList<Emp> selectForLike(String letter){
//        ArrayList<Emp> list = new ArrayList<Emp>();
//        //String sql = "select * from emp where ename like ?";
//        String sql = "select * from emp where ename like  \"%\" ? \"%\"";
//        try {
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,user,password);
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            //pstat.setString(1,"%"+letter+"%");//  %A%
//            pstat.setString(1,letter);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                list.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    //设计一个方法 查询emp表格中的所有记录 ArrayList<Emp>
//    public ArrayList<Emp> selectAll(){
//        ArrayList<Emp> list = new ArrayList<Emp>();
//        String sql = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP";
//        try {
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,user,password);
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                list.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    //设计一个方法 查询单条的emp表格记录
//    public Emp selectOne(Integer empno){
//        Emp emp = null;
//        String sql = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO = ?";
//        try {
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,user,password);
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            pstat.setInt(1,empno);
//            ResultSet rs = pstat.executeQuery();
//            if(rs.next()){
//                emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return emp;
//    }

}

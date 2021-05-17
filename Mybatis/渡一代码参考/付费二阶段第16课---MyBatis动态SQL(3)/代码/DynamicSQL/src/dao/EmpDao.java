package dao;

import domain.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@SuppressWarnings("all")
public class EmpDao {

    //一个SqlSession对象作为属性 支持dao中好多方法的执行
    private SqlSession sqlSession = MyUtil.getSqlSession(true);


    //设计一个方法 根据service层提供的条件查询emp对象(基于原生JDBC)
    public List<Emp> selectEmp(String deptno, String job){
        //设置一个返回值容器 用来存放查询出来的所有emp对象
        List<Emp> empList = new ArrayList();

        //为了以后将参数和SQL都交给pstat对象来处理
        //将参数包装在一个容器里 集合(有序) 对象
        Map<String,Object> params = new LinkedHashMap<>();

        //一条基本的SQL语句    利用StringBuilder拼接  提升性能
        String sql = "select * from emp where 1=1 ";
        //需要自己动态的拼接SQL语句
        if(deptno!=null && !"".equals(deptno)){
            sql += "and deptno = ? ";
            params.put("deptno",deptno);
        }
        if(job!=null && !"".equals(job)){
            sql += "and job = ? ";
            params.put("job",job);
        }
        System.out.println(sql);
        System.out.println(params);

        try {
            //JDBC流程
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false";
            String username = "root";
            String password = "123456";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            //将SQL和参数信息拼接完整才能执行     参数赋值
            //循环params集合内的每一个元素 对应问号信息
            int index = 1;//控制问号的位置(第一个开始)
            Iterator it = params.keySet().iterator();
            while(it.hasNext()){
                Object value = params.get(it.next());
                pstat.setObject(index++,value);
            }
            //执行查询操作
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getFloat("sal"));
                emp.setComm(rs.getFloat("comm"));
                emp.setDeptno(rs.getInt("deptno"));
                empList.add(emp);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //最终返回
        return empList;
    }
    //设计一个方法 根据service层提供的条件查询emp对象(基于MyBatis框架)
    public List<Emp> selectEmpByMybatis(Map<String,Object> params){
        //1.找寻SqlSession对象(属性)
        //2.让他帮我们去查询    sqlSession.selectList("sqlid",参数);
        System.out.println("这是MyBatisDao提供的支持");
        return sqlSession.selectList("selectEmpByMybatis",params);
    }



    //设计两个方法 分别查询所有的deptno  和  所有的job
    public List<Integer> selectAllDeptno(){
        List<Integer> deptnoList = new ArrayList();
        try {
            //原生JDBC
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false";
            String username = "root";
            String password = "123456";
            String sql = "select distinct deptno from emp order by deptno";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                deptnoList.add(rs.getInt("deptno"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptnoList;
    }
    public List<String> selectAllJob(){
        List<String> jobList = new ArrayList();
        try {
            //原生JDBC
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false";
            String username = "root";
            String password = "123456";
            String sql = "select distinct job from emp order by job";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                jobList.add(rs.getString("job"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }
}

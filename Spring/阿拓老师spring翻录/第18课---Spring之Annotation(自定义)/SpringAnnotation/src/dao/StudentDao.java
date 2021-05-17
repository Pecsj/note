package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据持久层
 *
 *          操作数据库读写     JDBC+SQL
 */
@Repository("studentDao")
public class StudentDao {

    //属性 小弟JdbcTemplate     SqlSession
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //dao自己的方法
    public void select(String ssex){
        System.out.println("daoMethod");
        String sql = "select * from student where ssex = ?";
        List list = jdbcTemplate.queryForList(sql,ssex);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}

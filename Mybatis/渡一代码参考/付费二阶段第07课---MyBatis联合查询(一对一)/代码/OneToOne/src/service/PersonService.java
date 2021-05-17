package service;

import dao.PersonDao;
import domain.Person;

import java.util.List;

public class PersonService {

    private PersonDao dao = new PersonDao();

    //单条记录查询 给定pid 查询一个人的信息
    public Person selectOne(Integer pid){
        return dao.selectOne(pid);
    }

    //多条记录查询 全部人员的信息+每个人自己的身份证信息
    public List<Person> selectAll(){
        return dao.selectAll();
    }
}

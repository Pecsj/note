package service;

import dao.PersonDao;
import domain.Person;
import util.MyUtil;

import java.util.List;

public class PersonService {

    private PersonDao dao = MyUtil.getMapper(PersonDao.class,true);

    //设计一个业务方法 根据人的id 查询人的信息+连同对应的身份证信息
    public Person selectOne(Integer pid){
        return dao.selectOne(pid);
    }

    public List<Person> selectAll(){
        return dao.selectAll();
    }
}

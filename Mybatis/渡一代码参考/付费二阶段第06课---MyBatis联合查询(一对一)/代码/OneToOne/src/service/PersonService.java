package service;

import dao.PersonDao;
import domain.Person;

public class PersonService {

    private PersonDao dao = new PersonDao();

    public Person selectOne(Integer pid){
        return dao.selectOne(pid);
    }
}

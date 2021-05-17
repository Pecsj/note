package test;

import domain.Person;
import service.PersonService;

public class TestMain {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        Person person = personService.selectOne(1);
        System.out.println(person);
    }
}

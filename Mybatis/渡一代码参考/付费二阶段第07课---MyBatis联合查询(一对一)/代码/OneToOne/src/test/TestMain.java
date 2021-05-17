package test;

import domain.IDCard;
import domain.Person;
import service.IDCardService;
import service.PersonService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
//        PersonService personService = new PersonService();
//        Person person = personService.selectOne(1);
//        System.out.println(person);

//        PersonService personService = new PersonService();
//        List<Person> personList = personService.selectAll();
//        for(Person person : personList){
//            System.out.println(person.getPid()+"--"+person.getPname()+"--"+person.getIdcard().getCardid());
//        }


        IDCardService idCardService = new IDCardService();
//        IDCard idcard = idCardService.selectOne("110000200001010101");
//        System.out.println(idcard);

        List<IDCard> idCardList = idCardService.selectAll();
        for(IDCard idCard : idCardList){
            System.out.println(idCard);
        }
    }
}

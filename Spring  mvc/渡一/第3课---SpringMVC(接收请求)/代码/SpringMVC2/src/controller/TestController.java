package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(path="testOne.do",params={"user=zzt","pass"})
    public void testOne(){
        System.out.println("testOne");
    }

    @RequestMapping(value="testTwo.do",method=RequestMethod.POST)
    public void testTwo(){
        System.out.println("testTwo");
    }

    @RequestMapping(path="testThree.do",headers={"Accept-Language"})
    public void testThree(){
        System.out.println("testThree");
    }

}

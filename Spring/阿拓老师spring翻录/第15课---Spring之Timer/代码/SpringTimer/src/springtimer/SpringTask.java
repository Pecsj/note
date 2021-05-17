package springtimer;

import java.util.ArrayList;

/**
 * 可以理解为是刚才的那个Task
 * 类中只有一个具体的事情(任务)
 * 没有timer帮我们做倒计时
 */
public class SpringTask {

    private ArrayList<String> userList = new ArrayList();

    {
        userList.add("博哥");
        userList.add("艾薇");
        userList.add("语晴");
        userList.add("Andy");
        userList.add("Ella");
        userList.add("Doris");
    }

    //具体的事情(刚才那个任务的方法)
    public void doSomething(){
        for(String user : userList){
            System.out.println("给"+user+"发送一条信息:[阿拓老师很帅!!!]");
        }
    }

}

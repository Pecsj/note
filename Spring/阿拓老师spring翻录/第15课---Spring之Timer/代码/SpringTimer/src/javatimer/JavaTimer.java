package javatimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaTimer {

    //做一个小计时器
    //模拟每天晚上  给所有同学发送短信(邮件)

    public static void main(String[] args) throws ParseException {
        System.out.println("准备做坏事儿啦~~~");
        //用来存储用户的名字  手机号  邮箱。。。
        //最好创建一个集合(随时扩容)
        String[] userArray = {"博哥","艾薇","语晴","Andy","Ella","Doris"};
        ArrayList<String> userList = new ArrayList(Arrays.asList(userArray));
        //每天晚上凌晨2点 发送垃圾短信
        //需要处理一下自己定义的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        //可以将自定义第一个字符串格式  转化为Date     数据库中的to_date('值','格式')函数
        Date firstTime = sdf.parse("2020-05-25 15:38:30");
        //可以找一个计时器对象来帮我们倒计时  时间到了就做事
        Timer timer = new Timer();
        //让timer帮我们做事情
        timer.schedule(new TimerTask(){
            @Override
            public void run() {//最终的任务
                for(String user : userList){
                    System.out.println("给"+user+"发送一条信息:[阿拓老师很帅!!!]");
                }
            }
        },firstTime,3000);
    }
}

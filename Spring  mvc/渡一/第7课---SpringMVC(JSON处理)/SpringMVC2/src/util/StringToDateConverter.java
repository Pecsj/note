package util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义一个类
 * 目的是为了将String类型转化成Date类型
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        System.out.println("自定义转换器");
        Date date = null;
        //自己定义的一个转换规则
        //将请求发送过来的String信息 转化成自己要的那个对象
        //方法中的变量s就是请求传递过来的那个信息
        //  2002-01-01
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //将转化后的对象返回
        return date;
    }

}

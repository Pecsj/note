package dao;

import domain.IDCard;
import domain.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface PersonDao {

    //设计一个方法 根据人的id 查询人的信息+连同对应的身份证信息
    @Select("select * from person where pid = #{pid}")
    @Results(
            id="selectOne",
            value={
                    @Result(property="pid",column="pid",id=true),
                    @Result(property="pname",column="pname"),
                    @Result(property="idCard",javaType=IDCard.class,column="cardid",one=@One(select="selectOneIDCard",fetchType=FetchType.LAZY))
            }
    )
    public Person selectOne(Integer pid);//方法返回值对应的是xml resultMap标签中的type属性

    //辅助方法
    @Select("select * from idcard where cardid = #{cardid}")
    public IDCard selectOneIDCard(String cardid);

    //利用原来的xml形式
    //  文件中有好多
    //      1.namespace----类名
    //      2.id-----------方法名
    //      3.<select>-----@Select
    //      4.标签中一条SQL--注解内有一条SQL
    //      5.标签中resultMap-----@Results(自定义规则)
    //          id                  id
    //          result              result
    //          association         对象
    //          辅助查询              辅助查询--(一个方法 方法上的注解 SQL)
    //      6.两个对象 第二个对象延迟机制 settings设置-----注解里设置


    @Select("select * from person")
    @ResultMap("selectOne")
    public List<Person> selectAll();

}

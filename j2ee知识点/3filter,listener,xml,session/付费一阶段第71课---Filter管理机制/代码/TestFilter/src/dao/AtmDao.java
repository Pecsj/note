package dao;

import domain.Atm;

public class AtmDao {

    //设计一个方法  单条记录查询
    public Atm selectOne(String aname){
        Atm atm = null;
        //JDBC操作数据库
        if(aname.equals("zhangsan")){
            atm = new Atm("zhangsan","333",300F);//应该从数据库查询  将查询的结果存入atm对象中
        }
        return atm;
    }
}

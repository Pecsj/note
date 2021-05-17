package dynamic;

import org.apache.ibatis.annotations.Param;

public class EmpDynamic {

    //类名随意写
    //方法名   类中只有一个方法    如果使用默认方法名   以后注解找的时候可以省略
    //          provideSql(使用默认的 找寻时可以省略)
    //方法名   自己随意写的也可以   找寻的时候需要告知具体哪个方法

    //一个普通方法    目的自己动态拼接SQL
    //  参数?     job deptno
    //  返回值?    SQL
    public String provideSql(@Param("job")String job,@Param("deptno")Integer deptno){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from emp where 1=1 ");
        if(job!=null && !"".equals(job)){
            sb.append(" and job = #{job}");
        }
        if(deptno!=null){
            sb.append(" and deptno = #{deptno}");
        }
        return sb.toString();
    }


    //一个普通方法    目的是自己动态拼接SQL
    //  参数 数组 集合 empnos
    //  返回值String
    public String getDynamicSQL(@Param("empnos")Integer...empnos){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from emp where empno in ");
        sb.append("(");//open="("
        for(int i=0;i<empnos.length;i++){
            sb.append(empnos[i]);
            sb.append(",");//   separator=","
        }
        sb.delete(sb.length()-1,sb.length());//多余的,删掉
        sb.append(")");//close=")"
        return sb.toString();
    }

}

package service;

import dao.EmpDao;
import domain.Emp;

import java.util.ArrayList;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //设计一个方法 负责将用户从视图层传递过来的页码 转换成 dao层需要的行索引
    //  是否需要参数---->页码int page
    //  是否需要返回值-->ArrayList<Emp>
//    public ArrayList<Emp> changePageToRowIndex(int page){
//        //1.负责将page计算成 rowIndex
//        //  page==1  rowIndex==0
//        //  page==2  rowIndex==5
//        //  page==3  rowIndex==10
//        int rowIndex = (page-1)*5;
//        //2.调用dao 让他去做事
//        ArrayList<Emp> list = dao.selectByPaging(rowIndex);
//        //3.dao方法的返回值当做我们方法自己的结果 交个用户
//        return list;
////        return dao.selectByPaging((page-1)*5);
//    }
}

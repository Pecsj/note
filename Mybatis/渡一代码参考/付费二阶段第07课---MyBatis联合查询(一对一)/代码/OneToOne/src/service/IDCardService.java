package service;

import dao.IDCardDao;
import domain.IDCard;

import java.util.List;

public class IDCardService {

    private IDCardDao dao = new IDCardDao();

    //根据身份证号 查询人+身份证信息
    public IDCard selectOne(String cardid){
        return dao.selectOne(cardid);
    }
    //全部信息查询
    public List<IDCard> selectAll(){
        return dao.selectAll();
    }
}

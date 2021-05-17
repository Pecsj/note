package service;

import dao.AreaDao;
import domain.Area;

import java.util.ArrayList;

public class AreaService {

    //dao作为树形
    private AreaDao dao = new AreaDao();

    //根据国家编号查询地区
    public ArrayList<Area> selectAreaByCid(Integer cid){
        return dao.selectAreaByCid(cid);
    }
}

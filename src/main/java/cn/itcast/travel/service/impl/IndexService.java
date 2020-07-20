package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class IndexService {
    @Autowired
    private RouteDao routeDAO;
    public List<Route> getIndexData(){
        List<Route> lrs=new ArrayList<Route>();
        Random r=new Random();
        Route t;
        int rid;
        for (int i=0;i<26;i++){
            rid=r.nextInt(500)+1;
            t=routeDAO.findOne(rid);
            lrs.add(t);
        }
        return lrs;
    }
}

package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDAO;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService {
    @Autowired
    private FavoriteDAO favoriteDAO;
    @Autowired
    private RouteDao routeDao;
    public void add(int rid,int uid){
        favoriteDAO.add(rid, uid);
    }
    public void remove(int rid,int uid){
        favoriteDAO.remove(rid,uid);
    }

    public List<Route> myCollect(int uid){
        System.out.println(favoriteDAO);
        List<Integer> rids=favoriteDAO.findRidsByUid(uid);
        List<Route> routeList=new ArrayList<Route>();
        for(int i:rids){
            routeList.add(routeDao.findOne(i));
        }
        return routeList;
    }
}

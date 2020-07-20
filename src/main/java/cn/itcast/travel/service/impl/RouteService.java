package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.RouteDAO;
import cn.itcast.travel.dao.impl.RouteImgDAO;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;

import java.util.List;


public class RouteService {
    private RouteDAO routeDAO=new RouteDAO();
    private RouteImgDAO routeImgDAO=new RouteImgDAO();
    public RouteService(){}
    public Route getRoute(int rid){
        Route route = routeDAO.findOne(rid);
        return route;
    }

    public List<RouteImg> getRouteImg(int rid){
        return routeImgDAO.findByRid(rid);
    }

    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDAO.findTotalCount(cid);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<Route> list = routeDAO.findByPage(cid,start,pageSize,rname);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);
        return pb;
    }
}

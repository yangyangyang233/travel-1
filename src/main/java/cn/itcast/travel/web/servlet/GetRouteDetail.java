package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.service.impl.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="GetRouteDetail",urlPatterns = "/getRoutDetail")
public class GetRouteDetail extends HttpServlet {
    RouteService routeService=new RouteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rid =Integer.parseInt(req.getParameter("rid")) ;
        Route route = routeService.getRoute(rid);
        List<RouteImg> routeImgList = routeService.getRouteImg(rid);
        req.getSession().setAttribute("route",route);
        req.getSession().setAttribute("routeImgList",routeImgList);
        req.getSession().setAttribute("rid",route.getRid());
        resp.sendRedirect("route_detail.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

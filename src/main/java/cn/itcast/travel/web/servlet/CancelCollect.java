package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.CollectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancelCollect",urlPatterns = "/cancelcollect")
public class CancelCollect extends HttpServlet {
    private CollectService collectService=new CollectService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid=Integer.parseInt(req.getSession().getAttribute("uid").toString());
        int rid=Integer.parseInt(req.getSession().getAttribute("rid").toString());
        collectService.remove(rid,uid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

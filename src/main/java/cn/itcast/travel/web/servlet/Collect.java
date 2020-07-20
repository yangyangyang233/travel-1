package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.CollectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "Collect",urlPatterns = "/collect")
public class Collect extends HttpServlet {
    private CollectService collectService=new CollectService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getSession().setAttribute("uid",1);
        String suid="";
        System.out.println(req.getSession().getAttribute("uid"));
        if(req.getSession().getAttribute("uid")!=null){
            suid=req.getSession().getAttribute("uid").toString();
        }else {
            resp.sendRedirect("login.html");
        }

        int uid=Integer.parseInt(suid);
        System.out.println("uid:"+uid);
        int rid=Integer.parseInt(req.getSession().getAttribute("rid").toString());
        if(true){
            collectService.add(rid,uid);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

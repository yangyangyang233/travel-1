package cn.itcast.travel.controller;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.impl.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CollectController {
    @Autowired
    private CollectService collectService;
    @RequestMapping("collect")
    public String collect(HttpSession session){
        String suid="";
        System.out.println(session.getAttribute("uid"));
        if(session.getAttribute("uid")!=null){
            suid=session.getAttribute("uid").toString();
        }else {
            //resp.sendRedirect("login.html");
            return "redirect:login.html";
        }

        int uid=Integer.parseInt(suid);
        System.out.println("uid:"+uid);
        int rid=Integer.parseInt(session.getAttribute("rid").toString());
        collectService.add(rid,uid);
        return null;
    }

    @RequestMapping("/mycollect")
    public String mycollect(HttpSession session){
        int uid=Integer.parseInt(session.getAttribute("uid").toString());
        List<Route> myRoutes = collectService.myCollect(uid);
        session.setAttribute("myRoutes",myRoutes);
        //resp.sendRedirect("myfavorite.jsp");
        return "myfavorite";
    }
}

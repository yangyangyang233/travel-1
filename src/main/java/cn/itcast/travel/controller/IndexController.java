package cn.itcast.travel.controller;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.impl.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/index")
    public String getIndexData(HttpSession session){
        //从数据库获取旅游信息
        List<Route> lr = indexService.getIndexData();
//        req.getSession().setAttribute("RouteList",lr);
//        req.getSession().setAttribute("t",3);
//        resp.sendRedirect("index.jsp");
        //model.addAttribute("RouteList",lr);
        session.setAttribute("RouteList",lr);
        return "index";
    }
}

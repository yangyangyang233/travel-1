<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>中国旅游网-我的收藏</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" href="css/index.css">
       <style>
           .tab-content .row>div {
            margin-top: 16px;
           } 
           .tab-content {
            margin-bottom: 36px;
           }
       </style>
       <script src="js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <div id="header"></div>
         <!-- 排行榜 start-->
        <section id="content">            
            <section class="hemai_jx">
                <div class="jx_top">
                    <div class="jx_tit">
                        <img src="images/icon_5.jpg" alt="">
                        <span>我的收藏</span>
                    </div>                    
                </div>
                <div class="jx_content">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">

                            <c:forEach items="${sessionScope.myRoutes}" var="route">
                                <div class="col-md-3">
                                    <a href="<c:url value="getRoutDetail?rid=${route.rid}"/>">
                                        <img src="<c:url value="${route.rimage}"/>" alt="">
                                        <div class="has_border">
                                            <h3>${route.rname}</h3>
                                            <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>

                            </div>
                        </div>                       
                    </div>
                </div>
                <div class="pageNum">
                    <ul>
                        <li><a href="">首页</a></li>
                        <li class="threeword"><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#">9</a></li>
                        <li><a href="#">10</a></li>
                        <li class="threeword"><a href="javascript:;">下一页</a></li>
                        <li class="threeword"><a href="javascript:;">末页</a></li>
                    </ul>
                </div>
            </section>                      
        </section>
        <!-- 排行榜 end-->
    	
         <!--引入尾部-->
    	<div id="footer"></div>
        <!--导入布局js，共享header和footer-->
        <script type="text/javascript" src="js/include.js"></script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="gb2312">
<title>个人相册 | Sheen的个人博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="sheen" />
<meta name="description" content="sheen" />
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" />
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>
<body>
<div class="topnav">
<a href="#" >Sheen博客</a>――作品来自：<a href="#" >作者创作或转载</a>
</div>
<div id="wrapper">
  <header>
    <div class="headtop"></div>
    <div class="contenttop">
      <div class="logo f_l">Sheen博客</div>
      <div class="search f_r">
        <form action="${pageContext.request.contextPath}/search" method="get">
          <input name="keys" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
          <input name="show" value="title" type="hidden">
          <input name="tempid" value="1" type="hidden">
          <input name="tbname" value="news" type="hidden">
          <input name="Submit" class="input_submit" value="搜索" type="submit" >
         </form>
      </div>
      <div class="blank"></div>
      <nav>
        <div  class="navigation">
          <ul class="menu">
            <li><a href="${pageContext.request.contextPath}/">网站首页</a></li>
            
            
           
             <li><a href="#">技术文章</a>
               <ul>
                 <c:forEach var="item" items="${requestScope.alltype}" > 
                    <li id="${item.type}" > <a id="${item.type}" href="${pageContext.request.contextPath}/search?type=${item.type}" >${item.type}</a></li>
                </c:forEach>
              </ul>
            </li>
             
            <li><a href="#">关于我</a>
              <ul>
                <li><a href="${pageContext.request.contextPath}/aboutme">个人简介</a></li>
                <li><a href="${pageContext.request.contextPath}/Mypicshow"  >个人相册</a></li>
                <li><a href="${pageContext.request.contextPath}/MyDayNews" >个人日记</a></li>
                <li><a href="${pageContext.request.contextPath}/studynote">学习笔记</a></li>

              </ul>
            </li>
            
            
            <li><a href="#">福利专区</a>
              <ul>
                <li><a href="${pageContext.request.contextPath}/resources">资源共享</a></li>
   				<li><a href="${pageContext.request.contextPath}/share">作品分享</a></li>
              </ul>
            </li>
            
            
            <li><a href="#" onclick="alert('功能暂未开发')">给我留言</a> </li>
          </ul>
        </div>
      </nav>
      <SCRIPT type=text/javascript>
	// Navigation Menu
	$(function() {
		$(".menu ul").css({display: "none"}); // Opera Fix
		$(".menu li").hover(function(){
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown("normal");
		},function(){
			$(this).find('ul:first').css({visibility: "hidden"});
		});
	});
</SCRIPT> 
   </div>
  </header>
  <div class="container">
  <div class="con_content">
    <div class="about_box">
      <h2 class="nh1"><span>您现在的位置是：<a href="${pageContext.request.contextPath}/" target="_blank">网站首页</a>>><a href="Mypicshow" target="_blank">个人相册</a></span><b>个人相册</b></h2>
      <ul class="about_content">
          <div style="width:150px;height: 100px;display: table-cell; vertical-align: middle;text-align: center;border:1px solid #000;"> <img src = "images/${name}.jpg"/> </div>
      </ul>
     <!--  <div class="pagelist">页次：1/1 每页25 总数10<a href="/">首页</a><a href="/">上一页</a><a href="/">下一页</a><a href="/">尾页</a></div> -->
    </div>
  </div>
  <div class="blank"></div>
  <!-- container代码 结束 -->
  
  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="#">Sheen的个人博客</a> </p>
      </div>
      <div class="f_r textr">
        <p>NO GAME NO LIFE</p>
      </div>
    </div>
  </footer>
</div>
</body>
</html>
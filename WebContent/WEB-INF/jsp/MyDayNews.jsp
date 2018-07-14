<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="gb2312">
<title>个人日记 | Sheen的个人博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="个人博客模板古典系列之――江南墨卷" />
<meta name="description" content="个人博客模板古典系列之――江南墨卷" />
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" />
</head>
<body>
<div class="topnav">
<a href="#">Sheen博客</a>――作品来自：<a href="#">作者创作或转载</a>
</div>
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
          <input name="Submit" class="input_submit" value="搜索" type="submit" onclick="searchByKey()">
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
      <h2 class="nh1"><span>您现在的位置是：<a href="/" target="_blank">网站首页</a>>><a href="#" target="_blank">个人日记</a></span><b>个人日记</b></h2>
      <div class="dtxw box">
         <c:forEach var = "item" items="${diarylist}" varStatus="status">
       		 <li>
          		<div class="dttext f_l">
            		<ul>
              		<h2><a href="/">${item.title}</a></h2>
              		<p>${item.content}</p>
              		<span>${item.time_string}</span>
            	</ul>
          		</div>
          		<c:if test="${status.index==0}">
        	    	 <div class="xwpic f_r"><a href="#"><img src="images/guaidao.jpg"></a></div>
        	    </c:if>
        	    <c:if test="${status.index==1}">
            		 <div class="xwpic f_r"><a href="#"><img src="images/fuchouzhe.jpg"></a></div>
            	</c:if>
            	<c:if test="${status.index==2}">
            		 <div class="xwpic f_r"><a href="#"><img src="images/shashengwan.jpg"></a></div>
            	</c:if>
            	<c:if test="${status.index==3}">
            		 <div class="xwpic f_r"><a href="#"><img src="images/jiegeng.jpg"></a></div>
            	</c:if>
            	<c:if test="${status.index==4}">
            		 <div class="xwpic f_r"><a href="#"><img src="images/ali.jpg"></a></div>
            	</c:if>
            	<c:if test="${status.index==6}">
            		 <div class="xwpic f_r"><a href="#"><img src="images/re0.jpg"></a></div>
            	</c:if>
        	</li>
          </c:forEach>
          
      </div>
      <div class="pagelist">页次：${pageID}/${pageNum} 每页${pagesize} 总数:${size}<a href="${pageContext.request.contextPath}/MyDayNews/search?pageID=1">首页</a>
      <c:if test="${pageID!=1}">
          <a href="${pageContext.request.contextPath}/MyDayNews/search?pageID=<%=(int)request.getAttribute("pageID")-1 %>">上一页</a>
      </c:if>
      <c:if test="${pageID!=pageNum}">
          <a href="${pageContext.request.contextPath}/MyDayNews/search?pageID=<%=(int)request.getAttribute("pageID")+1 %>">下一页</a>
      </c:if>
     <a href="${pageContext.request.contextPath}/MyDayNews/search?pageID=${pageNum}">尾页</a></div>
    </div>
  </div>
  <div class="blank"></div>
  <!-- container代码 结束 -->
  
  <footer>
    <div class="footer">
      <div class="f_l">
 <p>All Rights Reserved 版权所有：<a href="/">Sheen的个人博客</a> </p>      </div>
      <div class="f_r textr">
        <p>NO GAME NO LIFE</p>
      </div>
    </div>
  </footer>
</div>
</body>
</html>
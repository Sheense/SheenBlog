<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="gb2312">
<title>学习笔记| Sheen的个人博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Sheen的个人博客" />
<meta name="description" content="Sheen的个人博客" />
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>

<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.1.min.js"></script>
<script src="js/modernizr.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/mainAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
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
       <form action="${pageContext.request.contextPath}/studynote/search" method="get">
          <input name="key" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
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
                <li><a href="${pageContext.request.contextPath}/Mypicshow">个人相册</a></li>
                <li><a href="${pageContext.request.contextPath}/MyDayNews">个人日记</a></li>
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
  <div class="jztop"></div>
  <div class="container">
    <div class="bloglist f_l" id="blogdiv">
    <!-- 博文预览区 -->
      <c:forEach var="item" items="${requestScope.studynotelist}" >
            <h3><a href="${pageContext.request.contextPath}/studynote/searchByID?id=${item.id}" target="_blank">${item.title}</a></h3>
      		<figure><a href="${pageContext.request.contextPath}/studynote/searchByID?id=${item.id}" target="_blank"><img src="${item.simplepic}" alt="${item.simplepic}"></a></figure>
      		<ul>
        		<p> ${item.introduction}</p>
        		<a title="阅读全文" href="${pageContext.request.contextPath}/studynote/searchByID?id=${item.id}" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
      		</ul>
      		<p class="dateview"><span>${item.time_string}</span><span>作者：${item.author}</span><span>类型：${item.type}</span><span>浏览量：${item.scanNum}</span></p>
      </c:forEach>
      
    <!-- 博文预览区 --> 
    </div>
    <div class="r_box f_r">
      <div class="tit01">
        <h3 class="tit">关注我</h3>
        <div class="gzwm">
          <ul>
            <li><a class="email" href="#" onclick="alert('功能暂未开发')">我的电话</a></li>
            <li><a class="qq" href="#" onclick="alert('功能暂未开发')">我的邮箱</a></li>
            <li><a class="tel" href="#"  onclick="alert('功能暂未开发')">我的QQ</a></li>
            <li><a class="prize" href="${pageContext.request.contextPath}/wechat">我的微信</a></li>
          </ul>
        </div>
      </div>
      <!--tit01 end-->
      <div class="ph">
        <h3 class="tit">点击排行</h3>
        <ul class="rank">
           <c:forEach var="item" items="${requestScope.randList}">
            <li><a href="${pageContext.request.contextPath}/searchAll?id=${item.id}" title="${item.title }" target="_blank">【${item.type}】${item.title}</a></li>
           </c:forEach>
        </ul>
      </div>
      <!--<div class="tuwen">
        <h3 class="tit">图文推荐</h3>
          <ul>
         <c:forEach var = "item" items="${requestScope.picwords}">
          <li><a href="/"><img src="${item.pic}"><b>${item.title}</b></a>
            <p><span class="tulanmu"><a href="/">${item.type}</a></span><span class="tutime">${item.time}</span></p>
          </li>
         </c:forEach>
        </ul>
      </div>-->
      <div class="ad"> <img src="images/lusheng.jpg"> </div>
      <div class="ad"> <img src="images/cangyi.jpg"> </div>
    </div>
  </div>
  <!-- container代码 结束 -->
  <div class="jzend"></div>
  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="/">Sheen的个人博客</a> </p>
      </div>
      <div class="f_r textr">
        <p>NO GAME NO LIFE</p>
      </div>
    </div>
  </footer>
</div>
</body>
</html>
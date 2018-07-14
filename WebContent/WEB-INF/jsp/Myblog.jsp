<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/logo.png">
<title>${requestScope.blog.title} | Sheen的个人博客</title>
<meta name="keywords" content="sheen博客" />
<meta name="description" content="sheen博客" />
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mainAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
<script src="${pageContext.request.contextPath}/js/shang.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>
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
                    <li id="${item.type}" > <a id="${item.type}" href="${pageContext.request.contextPath}/?type=${item.type}" >${item.type}</a></li>
                </c:forEach>
              </ul>
            </li>
             
            <li><a href="#">关于我</a>
              <ul>
                <li><a href="${pageContext.request.contextPath}/aboutme">个人简介</a></li>
                <li><a href="${pageContext.request.contextPath}/Mypicshow" >个人相册</a></li>
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
        <h2 class="nh1"><span>您现在的位置是：<a href="${pageContext.request.contextPath}/" target="_blank">网站首页</a>>><a href="${pageContext.request.contextPath}/?type=${requestScope.blog.type}" target="_blank">${requestScope.blog.type}</a></span><b>${requestScope.blog.title}</b></h2>
        <div class="f_box">
          <p class="a_title">${requestScope.blog.title}</p>
          <p class="p_title"></p>
            <p class="box_p"><span>发布时间：${requestScope.blog.time_string}</span><span>作者：${requestScope.blog.author}</span><span>来源：${requestScope.blog.fromwhere}</span><span>浏览量：${requestScope.blog.scanNum}</span></p>
          <!-- 可用于内容模板 -->
        </div>
        <ul class="about_content">
             ${requestScope.blog.content}
        </ul>

        <!-- container代码 结束 -->

          
      </div>
    </div>
    <div class="blank"></div>
  </div>
  <!-- container代码 结束 -->
<div class="comment">
    <div id="SOHUCS"></div>
<!-- <script type="text/javascript">
(function(){
var appid = 'cytk2a7nr';
var conf = '3437d86f4a4e9bf3aad1ef65fc2740b5';
var width = window.innerWidth || document.documentElement.clientWidth;
if (width < 960) {
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>

PC版
<div id="SOHUCS" sid="" ></div>
<script charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/changyan.js" ></script>
<script type="text/javascript">
window.changyan.api.config({
appid: 'cytk2a7nr',
conf: '3437d86f4a4e9bf3aad1ef65fc2740b5'
});
</script> -->

<!--PC和WAP自适应版-->
<!-- <div id="SOHUCS" sid="请将此处替换为配置SourceID的语句" ></div>
<script type="text/javascript">
(function(){
var appid = 'cytk2a7nr';
var conf = 'prod_53c868f5f3ac56a10e72d038ac860764';
var width = window.innerWidth || document.documentElement.clientWidth;
if (width < 960) {
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>
</div> -->
  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="#">Sheen个人博客</a> </p>
      </div>
      <div class="f_r textr">
        <p>NO GAME NO LIFE</p>
      </div>
    </div>
  </footer>
</div>
<!--百度推送代码-->
<!-- <script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script> -->
</body>
</html>

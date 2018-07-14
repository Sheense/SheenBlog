package priv.MyBlog.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.Blog;
import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.server.BlogServer;

@Controller
@RequestMapping("/Article")
public class UpdateAndWriteAndDeleteBlogs {

	@Autowired
	private BlogServer blogServer;
	
	@RequestMapping("/Add")
	public void writeBlog(HttpServletRequest request,HttpServletResponse response,Blog blog) throws Exception {
		request.setCharacterEncoding("UTF-8");
		blogServer.insertBlog(blog);
		response.sendRedirect(request.getContextPath()+"/admin/article");
	}
	@RequestMapping("/Delete")
	public void deleteBlog(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		blogServer.deleteBlog(id);
	}
	@RequestMapping("/CheckAll")
	public void deleteCheckAllBlog(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String ids[] = request.getParameterValues("checkbox");
		for(int i=0;i<ids.length;i++) {
			blogServer.deleteBlog(ids[i]);
		}
		response.sendRedirect(request.getContextPath()+"/admin/article");
	}
	
	@RequestMapping("/Update")
	public ModelAndView updateBlog(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView m = new ModelAndView();
		String id = request.getParameter("id");
		BlogCustom blogCustom=blogServer.selectBlogAll(id);
		m.addObject("blogCustom", blogCustom);
		m.setViewName("update-article");
		return m;
	}
	@RequestMapping("/UpdateLoad")
	public void updateLoadBlog(HttpServletRequest request,HttpServletResponse response,BlogCustom blogCustom) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		blogServer.updateBlog(blogCustom);
		response.sendRedirect(request.getContextPath()+"/admin/article");
	}
}

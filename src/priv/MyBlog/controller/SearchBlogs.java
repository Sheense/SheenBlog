package priv.MyBlog.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.server.BlogServer;

@Controller
public class SearchBlogs {

	//@Resource(name="blogServer")
	@Autowired
	private BlogServer blogServer;
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView modelAndView = new ModelAndView();
		String keys = request.getParameter("keys");
		String type = request.getParameter("type");
		BlogCustom blogCustom = new BlogCustom();
		if(keys!=null) {
			if(keys.trim().equals("")||keys.equals("请输入关键字")) {
				keys=null;
			}
			blogCustom.setBkey(keys);
		}
		if(type!=null) {
			blogCustom.setType(type);
		}		
		List<BlogCustom> bloglist = blogServer.selectBlogList(blogCustom);
        List<BlogCustom> alltype = blogServer.selectAllType();
        List<BlogCustom> randList = blogServer.selectRinkList();
        modelAndView.addObject("bloglist", bloglist);
        modelAndView.addObject("alltype",alltype);
        modelAndView.addObject("randList", randList);
        modelAndView.setViewName("main");
		return modelAndView;
	}
	@RequestMapping("/searchAll")
	public ModelAndView searchByAll(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String id=request.getParameter("id");
		
		//浏览量检测
		blogServer.addScanum(id);
		
		
		BlogCustom blogCustom = blogServer.selectBlogAll(id);
		List<BlogCustom> alltype = blogServer.selectAllType();
		if(blogCustom==null) {
			modelAndView.setViewName("error/404");
			return modelAndView;
		}
		modelAndView.addObject("alltype",alltype);
		modelAndView.addObject("blog",blogCustom);
		modelAndView.setViewName("Myblog");
		return modelAndView;
	}
}

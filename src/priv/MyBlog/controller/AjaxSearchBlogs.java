package priv.MyBlog.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.server.BlogServer;

@Controller
@RequestMapping("/search")
public class AjaxSearchBlogs {

	@Autowired
	private BlogServer blogServer;
	
	
	@RequestMapping("/byType")
	public void searchByType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StringBuffer sb = new StringBuffer("");
		String type = request.getParameter("type");
		BlogCustom blogCustom = new BlogCustom();
		blogCustom.setType(type);
		List<BlogCustom> list = blogServer.selectBlogList(blogCustom);
		sb.append("{\"blogs\":[");
		for(int i=0;i<list.size();i++) {
			sb.append("{\"blog\":{\"id\":\""+list.get(i).getId()+"\","
								+ "\"pic\":\""+list.get(i).getPic()+"\","
								+ "\"author\":\""+list.get(i).getAuthor()+"\","
								+ "\"time\":\""+list.get(i).getTime_string()+"\","
								+ "\"scanNum\":\""+list.get(i).getScanNum()+"\","
								+ "\"fromwhere\":\""+list.get(i).getFromwhere()+"\","
								+ "\"introduction\":\""+list.get(i).getIntroduction()+"\","
								+ "\"title\":\""+list.get(i).getTitle()+"\"}}");
			if(i!=(list.size()-1)) {
				sb.append(",");
			}
		}
		sb.append("]}");
        response.getWriter().write(sb.toString());		
	}
	@RequestMapping("/byKeys")
	public void searchByKeys(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StringBuffer sb = new StringBuffer("");
		String key = request.getParameter("keys");
		BlogCustom blogCustom = new BlogCustom();
		System.out.println(key);
		blogCustom.setBkey(key);
		List<BlogCustom> list = blogServer.selectBlogList(blogCustom);
		sb.append("{\"blogs\":[");
		for(int i=0;i<list.size();i++) {
			sb.append("{\"blog\":{\"id\":\""+list.get(i).getId()+"\","
					+ "\"pic\":\""+list.get(i).getPic()+"\","
					+ "\"author\":\""+list.get(i).getAuthor()+"\","
					+ "\"time\":\""+list.get(i).getTime_string()+"\","
					+ "\"scanNum\":\""+list.get(i).getScanNum()+"\","
					+ "\"fromwhere\":\""+list.get(i).getFromwhere()+"\","
					+ "\"introduction\":\""+list.get(i).getIntroduction()+"\","
					+ "\"title\":\""+list.get(i).getTitle()+"\"}}");
			if(i!=(list.size()-1)) {
				sb.append(",");
			}
		}
		sb.append("]}");
        response.getWriter().write(sb.toString());
	}
}

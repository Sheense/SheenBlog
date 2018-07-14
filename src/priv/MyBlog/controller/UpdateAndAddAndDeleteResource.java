package priv.MyBlog.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import priv.MyBlog.po.DownLoad;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.server.DownloadServer;

@Controller
@RequestMapping("/Resource")
public class UpdateAndAddAndDeleteResource {
	
	@Autowired
	private DownloadServer downloadServer;
	
	@RequestMapping("/Add")
	public void addResource(HttpServletRequest request,HttpServletResponse response,DownLoad download) throws Exception {
		request.setCharacterEncoding("UTF-8");
		downloadServer.insertResource(download);
		response.sendRedirect(request.getContextPath()+"/admin/resource");

	}
	
	@RequestMapping("/Delete")
	public void deleteResource(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		downloadServer.deleteResource(id);
	}
	@RequestMapping("/CheckAll")
	public void deleteCheckAllResource(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String ids[] = request.getParameterValues("checkbox");
		for(int i=0;i<ids.length;i++) {
			downloadServer.deleteResource(ids[i]);
		}
		response.sendRedirect(request.getContextPath()+"/admin/resource");
	}
	@RequestMapping("/Update")
	public ModelAndView updateResource(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView m = new ModelAndView();
		String id = request.getParameter("id");
		DownLoadCustom downLoadCustom=downloadServer.findDownLoadAllById(id);
		m.addObject("downLoadCustom", downLoadCustom);
		m.setViewName("update-resource");
		return m;
	}
	@RequestMapping("/UpdateLoad")
	public void updateLoadResource(HttpServletRequest request,HttpServletResponse response,DownLoadCustom downLoadCustom) throws Exception {
		request.setCharacterEncoding("UTF-8");
		downloadServer.updateResource(downLoadCustom);
		response.sendRedirect(request.getContextPath()+"/admin/resource");
	}
}

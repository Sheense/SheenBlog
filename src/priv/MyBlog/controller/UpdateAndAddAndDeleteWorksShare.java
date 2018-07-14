package priv.MyBlog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.Share;
import priv.MyBlog.po.ShareCustom;
import priv.MyBlog.server.WorksShareServer;



@Controller
@RequestMapping("/WorksShare")
public class UpdateAndAddAndDeleteWorksShare {

	@Autowired
	private WorksShareServer worksShareServer;
	
	@RequestMapping("/Add")
	public void addWorksShare(HttpServletRequest request,HttpServletResponse response,Share share) throws Exception {
		request.setCharacterEncoding("UTF-8");
		worksShareServer.insertWorksShare(share);
		response.sendRedirect(request.getContextPath()+"/admin/worksShare");
	}
	@RequestMapping("/Delete")
	public void deleteWorksShare(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		worksShareServer.deleteWorksShare(id);
	}
	@RequestMapping("/CheckAll")
	public void deleteCheckAllWorksShare(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String ids[] = request.getParameterValues("checkbox");
		for(int i=0;i<ids.length;i++) {
			worksShareServer.deleteWorksShare(ids[i]);
		}
		response.sendRedirect(request.getContextPath()+"/admin/worksShare");
	}
	@RequestMapping("/Update")
	public ModelAndView updateWorksShare(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView m = new ModelAndView();
		String id = request.getParameter("id");
		ShareCustom shareCustom=worksShareServer.findShareAllById(id);
		m.addObject("shareCustom", shareCustom);
		m.setViewName("update-worksShare");
		return m;
	}
	@RequestMapping("/UpdateLoad")
	public void updateLoadWorksShare(HttpServletRequest request,HttpServletResponse response,ShareCustom shareCustom) throws Exception {
		request.setCharacterEncoding("UTF-8");
		worksShareServer.updateWorksShare(shareCustom);
		response.sendRedirect(request.getContextPath()+"/admin/worksShare");
	}
}

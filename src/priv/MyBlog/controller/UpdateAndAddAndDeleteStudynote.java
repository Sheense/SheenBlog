package priv.MyBlog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.Share;
import priv.MyBlog.po.ShareCustom;
import priv.MyBlog.po.Studynote;
import priv.MyBlog.po.StudynoteCustom;
import priv.MyBlog.server.StudynoteServer;
import priv.MyBlog.server.WorksShareServer;

@Controller
@RequestMapping("/Studynote")
public class UpdateAndAddAndDeleteStudynote {

	@Autowired
	private StudynoteServer studynoteServer;
	
	@RequestMapping("/Add")
	public void addStudynote(HttpServletRequest request,HttpServletResponse response,Studynote studynote) throws Exception {
		request.setCharacterEncoding("UTF-8");
		studynoteServer.insertStudynote(studynote);
		response.sendRedirect(request.getContextPath()+"/admin/studynote");
	}
	@RequestMapping("/Delete")
	public void deleteStudynote(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		studynoteServer.deleteStudynote(id);
	}
	@RequestMapping("/CheckAll")
	public void deleteCheckAllStudynote(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String ids[] = request.getParameterValues("checkbox");
		for(int i=0;i<ids.length;i++) {
			studynoteServer.deleteStudynote(ids[i]);
		}
		response.sendRedirect(request.getContextPath()+"/admin/studynote");
	}
	@RequestMapping("/Update")
	public ModelAndView updateStudynote(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView m = new ModelAndView();
		String id = request.getParameter("id");
		StudynoteCustom studynoteCustom=studynoteServer.selectStudynoteAll(id);
		m.addObject("studynoteCustom", studynoteCustom);
		m.setViewName("update-studynote");
		return m;
	}
	@RequestMapping("/UpdateLoad")
	public void updateLoadstudynoteCustom(HttpServletRequest request,HttpServletResponse response,StudynoteCustom studynoteCustom) throws Exception {
		request.setCharacterEncoding("UTF-8");
		studynoteServer.updateStudynote(studynoteCustom);
		response.sendRedirect(request.getContextPath()+"/admin/studynote");
	}
}

package priv.MyBlog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.MyBlog.po.Diary;
import priv.MyBlog.po.DownLoad;
import priv.MyBlog.server.DiaryServer;

@Controller
@RequestMapping("/Diary")
public class DeleteAndAddDiary {

	@Autowired
	private DiaryServer diaryServer;
	
	@RequestMapping("/Add")
	public void addDiary(HttpServletRequest request,HttpServletResponse response,Diary diary) throws Exception {
		request.setCharacterEncoding("UTF-8");
		diaryServer.insertDiary(diary);
		response.sendRedirect(request.getContextPath()+"/admin/diary");

	}
	
	@RequestMapping("/Delete")
	public void deleteDiary(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		diaryServer.deleteDiary(id);
	}
	@RequestMapping("/CheckAll")
	public void deleteCheckAllDiary(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String ids[] = request.getParameterValues("checkbox");
		for(int i=0;i<ids.length;i++) {
			diaryServer.deleteDiary(ids[i]);
		}
		response.sendRedirect(request.getContextPath()+"/admin/diary");
	}
}

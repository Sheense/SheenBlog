package priv.MyBlog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.DiaryCustom;
import priv.MyBlog.server.DiaryServer;

@Controller
@RequestMapping("MyDayNews")
public class DiaryController {

	@Autowired
	private DiaryServer diaryServer;
	
	@RequestMapping("/search")
	public ModelAndView selectDiary(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int pagesize=6;
		int pageID = Integer.parseInt(request.getParameter("pageID"));
		System.out.println(pageID);//注释
		List<DiaryCustom> diarylist = diaryServer.selectDiaryBy(pagesize, pageID);
		modelAndView.addObject("diarylist",diarylist);
		modelAndView.addObject("size",diaryServer.diaryNum());
		modelAndView.addObject("pageNum", diaryServer.getPageNum(6));
		modelAndView.addObject("pagesize", pagesize);
		modelAndView.addObject("pageID", pageID);
		modelAndView.setViewName("MyDayNews");
		return modelAndView;
	}
	
}

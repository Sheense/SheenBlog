package priv.MyBlog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.po.StudynoteCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.StudynoteServer;

@Controller
@RequestMapping("/studynote")
public class StudynoteController {

	@Autowired
	private StudynoteServer studynoteServer;
	@Autowired
	private BlogServer blogServer;
	
	@RequestMapping("/search")
	public ModelAndView searchStudynote(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<StudynoteCustom> studynotelist= studynoteServer.selectStudynoteByKey(request.getParameter("key"));
		modelAndView.addObject("studynotelist", studynotelist);
		
		List<BlogCustom> alltype = blogServer.selectAllType();
		modelAndView.addObject("alltype",alltype);
		
		List<BlogCustom> randList = blogServer.selectRinkList();
		modelAndView.addObject("randList", randList);

		
		modelAndView.setViewName("Studynotelist");
		return modelAndView;
	}
	@RequestMapping("/searchByID")
	public ModelAndView searchStudynoteByID(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		studynoteServer.addScanNum(id);
		StudynoteCustom studynoteCustom = studynoteServer.selectStudynoteAll(id);
		modelAndView.addObject("studynoteCustom",studynoteCustom);
		modelAndView.setViewName("studynote");
		return modelAndView;
	}
}

package priv.MyBlog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.po.DiaryCustom;
import priv.MyBlog.po.Me;
import priv.MyBlog.po.StudynoteCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.DiaryServer;
import priv.MyBlog.server.MeServer;
import priv.MyBlog.server.StudynoteServer;


@Controller
public class UserController {
	

	@Autowired
	private BlogServer blogServer;
	@Autowired
	private DiaryServer diaryServer;
	@Autowired
	private MeServer meServer;
	@Autowired
	private StudynoteServer studynoteServer;
	
	
	@RequestMapping("/")
	public ModelAndView init(HttpServletRequest request) throws Exception{
    	ModelAndView m = new ModelAndView();
    	String type=request.getParameter("type");
    	BlogCustom blogCustoms = new BlogCustom();
    	if(type!=null) {
    		blogCustoms.setType(type);
    	}
        List<BlogCustom> bloglist = blogServer.selectBlogList(blogCustoms);
        List<BlogCustom> alltype = blogServer.selectAllType();
        List<BlogCustom> randList = blogServer.selectRinkList();
        m.addObject("bloglist", bloglist);
        m.addObject("alltype",alltype);
        m.addObject("randList", randList);
    	m.setViewName("main");
		return m;
	}
	@RequestMapping("/aboutme")
	public ModelAndView aboutMe() throws Exception {
		ModelAndView m = new ModelAndView();
		List<BlogCustom> alltype = blogServer.selectAllType();
        m.addObject("alltype",alltype);
        Me me = meServer.selectMe();
        m.addObject("me", me);
	    m.setViewName("about");
		return m;
	}
	@RequestMapping("/Mypicshow")
	public ModelAndView myPicShow() throws Exception{
		ModelAndView m = new ModelAndView();
		List<BlogCustom> alltype = blogServer.selectAllType();
        m.addObject("alltype",alltype);
	    m.setViewName("Mypicshow");
		return m;
	}
	@RequestMapping("/MyDayNews")
	public ModelAndView myDayNews() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<BlogCustom> alltype = blogServer.selectAllType();
		modelAndView.addObject("alltype",alltype);
	   
	    int pagesize=6;
		int pageID=1;
		
		List<DiaryCustom> diarylist = diaryServer.selectDiaryBy(pagesize, pageID);
		modelAndView.addObject("diarylist",diarylist);
		modelAndView.addObject("size",diaryServer.diaryNum());
		modelAndView.addObject("pageNum", diaryServer.getPageNum(6));
		modelAndView.addObject("pagesize", pagesize);
		modelAndView.addObject("pageID", pageID);
		modelAndView.setViewName("MyDayNews");
		return modelAndView;
	}
	@RequestMapping("/studynote")
	public ModelAndView Studynote() throws Exception {
		ModelAndView  modelAndView = new ModelAndView();
		List<BlogCustom> alltype = blogServer.selectAllType();
		modelAndView.addObject("alltype",alltype);
		modelAndView.setViewName("Studynotelist");
		List<StudynoteCustom> studynotelist = studynoteServer.selectStudynote();
		modelAndView.addObject("studynotelist", studynotelist);
		
        List<BlogCustom> randList = blogServer.selectRinkList();
        modelAndView.addObject("randList", randList);
        
		return modelAndView;
	}
	@RequestMapping("/show")
	public ModelAndView Show(HttpServletRequest request) throws Exception {
		ModelAndView  modelAndView = new ModelAndView();
		String name = request.getParameter("name");
        modelAndView.addObject("name", name);
        List<BlogCustom> alltype = blogServer.selectAllType();
        modelAndView.addObject("alltype",alltype);
        modelAndView.setViewName("showpic");
		return modelAndView;
	}
	
	@RequestMapping("/wechat")
	public ModelAndView Wechat() throws Exception {
		ModelAndView  modelAndView = new ModelAndView();
        List<BlogCustom> alltype = blogServer.selectAllType();
        modelAndView.addObject("alltype",alltype);
        modelAndView.setViewName("wechat");
		return modelAndView;
	}
	
}

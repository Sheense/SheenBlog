package priv.MyBlog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.po.DiaryCustom;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.po.Me;
import priv.MyBlog.po.ShareCustom;
import priv.MyBlog.po.StudynoteCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.DiaryServer;
import priv.MyBlog.server.DownloadServer;
import priv.MyBlog.server.MeServer;
import priv.MyBlog.server.StudynoteServer;
import priv.MyBlog.server.WorksShareServer;

@Controller
/*@RequiresPermissions("admin:login")*/
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BlogServer blogServer;
	@Autowired
	private DownloadServer downloadServer;
	@Autowired
	private WorksShareServer worksShareServer;
	@Autowired
	private DiaryServer diaryServer;
	@Autowired
	private MeServer meServer;
	@Autowired
	private StudynoteServer studynoteServer;
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
/*		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName!=null) System.out.println(exceptionClassName); */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminlogin");
		return modelAndView;
	}
	/**
	 * 去往主页面
	 *
	 */
/*	@RequiresPermissions("admin:login")*/
	@RequestMapping("/main")
	public ModelAndView goAdminMain() {
		ModelAndView m = new ModelAndView();
		m.setViewName("adminMain");
		return m;
	}
	/**
	 * 去往浏览文章列表页面
	 * @throws Exception 
	 * 
	 */
/*	@RequiresPermissions("admin:login")*/
	@RequestMapping("/article")
	public ModelAndView goToArticle() throws Exception {
		ModelAndView m = new ModelAndView();
		List<BlogCustom> bloglist = blogServer.selectBlogList(new BlogCustom());
		m.addObject("bloglist", bloglist);
		m.setViewName("article");
		return m;
	}
	/**
	 * 去往添加文章页面
	 * 
	 */
/*	@RequiresPermissions("admin:write")*/
	@RequestMapping("/add_article")
	public ModelAndView goToAddArticle() {
		ModelAndView m = new ModelAndView();
		m.setViewName("add-article");
		return m;
	}
	
	/**
	 * 去往资源共享页面
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/resource")
	public ModelAndView goToResource() throws Exception {
		ModelAndView m = new ModelAndView();
		List<DownLoadCustom> downlist = downloadServer.findDownLoadList();
		m.setViewName("adminResource");
		m.addObject("downlist", downlist);
		return m;	
	}
	/**
	 * 去往添加资源页面
	 */
	@RequestMapping("/addResource")
	public ModelAndView goToAddResource() {
		ModelAndView m = new ModelAndView();
		m.setViewName("add-resource");
		return m;	
	}
	/**
	 * 去往作品分享页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/worksShare")
	public ModelAndView goToWorksShare() throws Exception {
		ModelAndView m = new ModelAndView();
		List<ShareCustom> sharelist = worksShareServer.findShareList();
		m.addObject("sharelist", sharelist);
		m.setViewName("adminworksShare");
		return m;
	}
	/**
	 * 去往添加作品分享页面
	 */
	@RequestMapping("/addWorksShare")
	public ModelAndView goToAddWorksShare() {
		ModelAndView m = new ModelAndView();
		m.setViewName("add-worksShare");
		return m;
	}
	
	@RequestMapping("/diary")
	public ModelAndView goToDiary() throws Exception{
		ModelAndView m = new ModelAndView();
		List<DiaryCustom> diarylist = diaryServer.selectDiary();
		m.addObject("diarylist", diarylist);
		m.setViewName("admindiary");
		return m;
	}
	
	@RequestMapping("/addDiary")
	public ModelAndView goToAddDiary() throws Exception{
		ModelAndView m = new ModelAndView();
		m.setViewName("add-diary");
		return m;
	}
	
	@RequestMapping("/AboutMe")
	public ModelAndView goToAboutMe() throws Exception{
		ModelAndView m = new ModelAndView();
		m.setViewName("adminAboutMe");
		Me me = meServer.selectMe();
		m.addObject("me", me);
		return m;
	}
	@RequestMapping("/studynote")
	public ModelAndView goToStudynote() throws Exception{
		ModelAndView m = new ModelAndView();
		List<StudynoteCustom> studynotelist=studynoteServer.selectStudynote();
		m.setViewName("adminstudynote");
		m.addObject("studynotelist", studynotelist);
		return m;
	}
	@RequestMapping("/addStudynote")
	public ModelAndView goToAddStudynote() throws Exception{
		ModelAndView m = new ModelAndView();
		m.setViewName("add-studynote");
		return m;
	}
}

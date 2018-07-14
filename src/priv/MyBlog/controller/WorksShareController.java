package priv.MyBlog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.po.ShareCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.WorksShareServer;

@Controller
public class WorksShareController {

	@Autowired
	private WorksShareServer worksShareServer;
	
	@Autowired
	private BlogServer blogServer;
	
	@RequestMapping("/share")
	public ModelAndView initShareList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<ShareCustom>  sharelist= worksShareServer.findShareList();
		List<BlogCustom> alltype = blogServer.selectAllType();
	    List<BlogCustom> randList = blogServer.selectRinkList();
		modelAndView.addObject("sharelist", sharelist);
		modelAndView.addObject("alltype",alltype);
		modelAndView.addObject("randList", randList);
		modelAndView.setViewName("worksShareList");
		return modelAndView;
	}
	
	@RequestMapping("/share/search")
	public ModelAndView searchShareList(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String key=request.getParameter("keys");
		if(key==null||key.equals("请输入关键字")) {
			key="";
		}
		List<ShareCustom>  sharelist= worksShareServer.findShareListByKeys(key);
		List<BlogCustom> alltype = blogServer.selectAllType();
	    List<BlogCustom> randList = blogServer.selectRinkList();
		modelAndView.addObject("sharelist", sharelist);
		modelAndView.addObject("alltype",alltype);
		modelAndView.addObject("randList", randList);
		modelAndView.setViewName("worksShareList");
		return modelAndView;
	}
	
	@RequestMapping("/share/WorksShare")
	public ModelAndView searchThePage(HttpServletRequest request) throws Exception {
		String id= request.getParameter("id");
        worksShareServer.addWatchNum(id);
		ShareCustom  shareCustom  = worksShareServer.findShareAllById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("shareCustom",shareCustom);
		List<BlogCustom> alltype = blogServer.selectAllType();
		modelAndView.addObject("alltype",alltype);
		modelAndView.setViewName("WorksShare");
		return modelAndView;
	}
}

package priv.MyBlog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.BlogCustom;
import priv.MyBlog.po.DownLoadCustom;
import priv.MyBlog.server.BlogServer;
import priv.MyBlog.server.DownloadServer;

@Controller
public class ResourceController{

	@Autowired
    private DownloadServer downloadServer;
	@Autowired
	private BlogServer blogServer;
	
	@RequestMapping("/resources")
	public ModelAndView initDownLoadList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<DownLoadCustom>  downloadlist= downloadServer.findDownLoadList();
		List<BlogCustom> alltype = blogServer.selectAllType();
	    List<BlogCustom> randList = blogServer.selectRinkList();
		modelAndView.addObject("downloadlist", downloadlist);
		modelAndView.addObject("alltype",alltype);
		modelAndView.addObject("randList", randList);
		modelAndView.setViewName("resourceslist");
		return modelAndView;
	}
	@RequestMapping("/resources/search")
	public ModelAndView searchDownLoadList(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String key=request.getParameter("keys");
		if(key==null||key.equals("请输入关键字")) {
			key="";
		}
		List<DownLoadCustom>  downloadlist= downloadServer.findDownLoadListByKeys(key);
		List<BlogCustom> alltype = blogServer.selectAllType();
	    List<BlogCustom> randList = blogServer.selectRinkList();
		modelAndView.addObject("downloadlist", downloadlist);
		modelAndView.addObject("alltype",alltype);
		modelAndView.addObject("randList", randList);
		modelAndView.setViewName("resourceslist");
		return modelAndView;
	}
	@RequestMapping("/resources/Download")
	public ModelAndView searchThePage(HttpServletRequest request) throws Exception {
		String id= request.getParameter("id");
		downloadServer.addWatchNum(id);
		DownLoadCustom  downLoadCustom  = downloadServer.findDownLoadAllById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("downLoadCustom",downLoadCustom);
		List<BlogCustom> alltype = blogServer.selectAllType();
		modelAndView.addObject("alltype",alltype);
		modelAndView.setViewName("Download");
		return modelAndView;
	}
}

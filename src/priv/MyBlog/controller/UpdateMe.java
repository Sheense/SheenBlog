package priv.MyBlog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.MyBlog.po.Me;
import priv.MyBlog.server.MeServer;

@Controller
@RequestMapping("/AboutMe")
public class UpdateMe {

	
	@Autowired
	private MeServer meServer;
	
	@RequestMapping("Update")
	public void update(HttpServletRequest request,HttpServletResponse response,Me me) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		meServer.updateMe(me);
		response.sendRedirect(request.getContextPath()+"/admin/AboutMe");
	}
}

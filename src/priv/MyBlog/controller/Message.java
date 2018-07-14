package priv.MyBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Message {

	@RequestMapping("/refuse")
	public ModelAndView noPermission() {
		ModelAndView m = new ModelAndView();
		m.setViewName("refuse");
		return m;
	}
}

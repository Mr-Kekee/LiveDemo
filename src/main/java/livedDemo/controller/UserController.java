package livedDemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import livedDemo.model.LiveRedis;
import livedDemo.model.User;
import livedDemo.service.LiveService;
import livedDemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public static final String lOGIN_FORM = "login_form";
	public static final String REGISTER_FORM = "register_form";
	public static final String LIVELIST_FORM = "publisher";

	@Autowired
	private UserService userService;
	@Autowired
	private LiveService liveService;
	
	@RequestMapping("/register_form")
	public ModelAndView toRegisterForm(ModelMap model) {
		//need userMode
		User user = new User();
		model.addAttribute("user", user);
		return new ModelAndView(REGISTER_FORM);
	}
	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute("user") User user,
			HttpSession session, ModelMap model) {
		userService.save(user);
		session.setAttribute("user", user);
		List<LiveRedis> list = liveService.getAll();
		model.addAttribute("liveList", list);
		return new ModelAndView(LIVELIST_FORM);
	}
	
	@RequestMapping("/login_form")
	public ModelAndView toLoginForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return new ModelAndView(lOGIN_FORM);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user,
			HttpSession session, ModelMap model) {
		boolean flag = userService.checkPass(user);
		String message ;
		if(!flag) {
			message = "登录失败";
			model.addAttribute("message", message);
			return new ModelAndView(lOGIN_FORM);
		}else{
			message = "登录成功";
			List<LiveRedis> list = liveService.getAll();
			model.addAttribute("liveList", list);
			model.addAttribute("user", user);
			model.addAttribute("message", message);
			return new ModelAndView(LIVELIST_FORM);
		}
	}
	
	
}

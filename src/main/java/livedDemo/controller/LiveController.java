package livedDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import livedDemo.model.LiveRedis;
import livedDemo.service.LiveService;

@Controller
public class LiveController {
	
	@Autowired
	private LiveService liveService;

	@RequestMapping(value = "/publisher", method = RequestMethod.GET)
	public ModelAndView toPublisherView(ModelMap model) {
		LiveRedis liveRedis = new LiveRedis();
		model.addAttribute("live", liveRedis);
		return new ModelAndView("publisher");
	}
	
	@RequestMapping(value = "/publisher", method = RequestMethod.POST)
	public ModelAndView publisher(@ModelAttribute(value = "live")LiveRedis liveRedis,
			ModelMap model) {
		liveService.save(liveRedis);
		List<LiveRedis> list = liveService.getAll();
		model.addAttribute("liveList", list);
		return new ModelAndView("liveList");
	}
	
	@RequestMapping(value = "/live", method = RequestMethod.GET)
	public ModelAndView live(ModelMap model, HttpServletRequest request) {
		String keyName = request.getParameter("keyName");
		model.addAttribute("keyName", keyName);
		return new ModelAndView("live");
	}
}

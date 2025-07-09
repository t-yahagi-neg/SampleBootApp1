package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private boolean flag = false;

	@GetMapping()
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		flag = !flag;
		mav.addObject("flag", flag);
		mav.addObject("msg", "メッセージを表示します。");
		return mav;
	}
}

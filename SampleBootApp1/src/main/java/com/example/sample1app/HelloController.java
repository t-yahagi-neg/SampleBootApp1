package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping()
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg","HelloController/indexのページです。");
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("/other")
	public String other() {
		return "redirect:/";
	}

	@GetMapping("/home")
	public String home() {
		return "forward:/";
	}
}

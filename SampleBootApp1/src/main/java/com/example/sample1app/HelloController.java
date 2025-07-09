package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/{num}")
	public ModelAndView index(@PathVariable("num") int num, ModelAndView mav) {
		int total = 0;
		for (int i = 1; i <= num; i++) {
			total += i;
		}
		mav.addObject("msg", num + "までの合計を計算します。");
		mav.addObject("content", "total: " + total);
		mav.setViewName("index");
		return mav;
	}
}

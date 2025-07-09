package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping()
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		String msg = """
				<div class="border border-primary">
					<h2>Message</h2>
					<p>This is sample message!</p>
				</div>
				""";
		mav.addObject("msg", msg);
		return mav;
	}
}

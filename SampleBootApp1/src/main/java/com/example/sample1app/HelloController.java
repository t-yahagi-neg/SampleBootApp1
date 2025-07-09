package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

	@GetMapping("/{num}")
	public String index(@PathVariable("num") int num, Model model) {
		int res = 0;
		for (int i = 1; i <= num; i++) {
			res += i;
		}
		model.addAttribute("msg", "total: " + res);
		return "index";
	}
}

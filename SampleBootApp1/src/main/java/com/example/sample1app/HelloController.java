package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

	@GetMapping("/{temp}")
	public String index(@PathVariable("temp") String temp) {
		switch(temp) {
		case "index":
			return "index";
		default:
			return "other";
		}
	}
}

package com.example.sample1app;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;

@Controller
public class HelloController {

	@GetMapping()
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title","ラムダ式のサンプル");
		mav.addObject("msg","これはラムダ式を利用してメッセージを表示したものです。");

		Lambda fn = new Lambda() {
			public void execute (Fragment frag, Writer out) throws IOException {
				out.write("<div class=\"alert alert-primary\">");
				frag.execute(out);
				out.write("</div>");
			}
		};
		mav.addObject("fn",fn);
		return mav;
	}
}
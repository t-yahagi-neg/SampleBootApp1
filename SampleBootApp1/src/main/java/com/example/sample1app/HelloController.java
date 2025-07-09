package com.example.sample1app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@Controller
public class HelloController {

	@Autowired
	PersonRepository repository;

	@GetMapping()
	public ModelAndView index(@ModelAttribute("formModel") Person Person,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Hello page");
		mav.addObject("msg", "this is JPA sample data.");
		Iterable<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	@PostMapping()
	@Transactional
	public ModelAndView form(@ModelAttribute("formModel") Person Person,
			ModelAndView mav) {
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/");
	}
}
package com.example.sample1app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.annotation.PostConstruct;
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

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@ModelAttribute Person Person,
			@PathVariable("id") int id, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit Person.");
		Optional<Person> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@PostMapping("/edit")
	@Transactional
	public ModelAndView update(@ModelAttribute Person Person,
			ModelAndView mav) {
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/");
	}

	@PostConstruct
	public void init() {
		// 1つ目のダミーデータ作成
		Person p1 = new Person();
		p1.setName("taro");
		p1.setAge(39);
		p1.setMail("taro@yamada");
		repository.saveAndFlush(p1);
		// 2つ目のダミーデータ作成
		Person p2 = new Person();
		p2.setName("hanako");
		p2.setAge(28);
		p2.setMail("hanako@flower");
		repository.saveAndFlush(p2);
		// 3つ目のダミーデータ作成
		Person p3 = new Person();
		p3.setName("sachiko");
		p3.setAge(17);
		p3.setMail("sachico@happy");
		repository.saveAndFlush(p3);
	}
}
package com.example.sample1app;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.MessageRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	MessageRepository repository;

	@PersistenceContext
	EntityManager entityManager;

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav,
			@ModelAttribute("formModel") Message message) {
		mav.setViewName("messages/index");
		mav.addObject("title", "Message");
		mav.addObject("msg", "Messageのサンプルです。");
		mav.addObject("formModel", message);
		List<Message> list = (List<Message>) repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	@PostMapping("/")
	@Transactional
	public ModelAndView msgform(ModelAndView mav,
			@ModelAttribute("formModel") Message message) {
		mav.setViewName("showMessage");
		message.setDatetime(Calendar.getInstance().getTime());
		repository.saveAndFlush(message);
		mav.addObject("title", "Message");
		mav.addObject("msg", "新しいMessageを受け付けました。");
		return new ModelAndView("redirect:/msg/");
	}
}

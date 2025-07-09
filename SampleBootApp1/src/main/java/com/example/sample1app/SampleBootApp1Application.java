package com.example.sample1app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@SpringBootApplication
@RestController
public class SampleBootApp1Application {

	DataObject[] data = {
			new DataObject("noname","no email address",0),
			new DataObject("taro","taro@yamada",39),
			new DataObject("hanako","hanako@flower",28),
			new DataObject("sachiko","sachiko@happy",17),
			new DataObject("jiro","jiro@change",6)
	};

	public static void main(String[] args) {
		SpringApplication.run(SampleBootApp1Application.class, args);
	}

	@GetMapping("/{num}")
	public DataObject index(@PathVariable("num") int num) {
		int n = num < 0 ? 0 : num >= data.length ? 0 : num;
		return data[n];
	}
}

@Data
class DataObject {
	private String name;
	private String mail;
	private int age;

	public DataObject(String name, String mail, int age) {
		super();
		this.name = name;
		this.mail = mail;
		this.age = age;
	}
}

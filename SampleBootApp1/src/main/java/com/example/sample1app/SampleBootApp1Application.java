package com.example.sample1app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootApplication
@RestController
public class SampleBootApp1Application implements CommandLineRunner {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String[] args) {
		init();
		Person person = entityManager.find(Person.class, 1);
		System.out.println("+-------------------------------------+");
		System.out.println(person.getName() + ", " + person.getMail() + ", " + person.getAge());
		System.out.println("+-------------------------------------+");
	}

	public void init() {
		// 1つ目のダミーデータ作成
		// Person p1 = new Person();
		// p1.setName("taro");
		// p1.setAge(39);
		// p1.setMail("taro@yamada");
		// repository.saveAndFlush(p1);
		// ……必要に応じて追記……
	}
}
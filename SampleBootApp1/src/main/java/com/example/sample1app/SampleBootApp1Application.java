package com.example.sample1app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleBootApp1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String[] args) {
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("| this is CommandLine Runner programl. |");
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("[" + String.join(", ", args) + "]");
	}

}

package com.example.sample1app;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleBootApp1Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
		app.setBannerMode(Mode.OFF);
		app.setHeadless(false);
		app.run(args);
	}

	@Override
	public void run(ApplicationArguments args) {
		JFrame frame = new JFrame("Spring Boot Swing App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.add(new JLabel("Spring Boot Application."));
		frame.setVisible(true);
	}

}

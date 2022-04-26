package com.fujitsu.exam_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan ({"com.fujitsu.exam_system"})
@EnableAutoConfiguration


public class Exam_System {

	public static void main(String[] args) {
		SpringApplication.run(Exam_System.class, args);
	}

}

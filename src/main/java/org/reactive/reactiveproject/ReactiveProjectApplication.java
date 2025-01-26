package org.reactive.reactiveproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReactiveProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProjectApplication.class, args);
	}

}

package com.library.LibMgmt2025;

import com.library.LibMgmt2025.test.TestTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibMgmt2025Application {

	@Bean
	public TestTask testTask() {
		return new TestTask();
	}
	public static void main(String[] args) {

		SpringApplication.run(LibMgmt2025Application.class, args);
	}

}

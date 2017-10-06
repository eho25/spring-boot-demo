package com.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
public class BootPracticeApplication {

	public static void main(String[] args) {
		System.setProperty("input", "file:"+ new File("C:/Users/eho/workspace/boot-practice/boot-practice/batch-files/in.csv").getAbsolutePath());
		System.setProperty("output", "file:"+ new File("C:/Users/eho/workspace/boot-practice/boot-practice/batch-files/out.csv").getAbsolutePath());
		SpringApplication.run(BootPracticeApplication.class, args);
	}
}

package com.uuhnaut69.todo;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException  {
		SpringApplication.run(TodoApplication.class, args);
	}

}

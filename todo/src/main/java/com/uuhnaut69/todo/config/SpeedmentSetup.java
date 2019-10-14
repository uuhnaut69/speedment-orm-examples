package com.uuhnaut69.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.speedment.runtime.core.ApplicationBuilder.LogType;
import com.uuhnaut69.tododb.TododbApplication;
import com.uuhnaut69.tododb.TododbApplicationBuilder;

@Configuration
public class SpeedmentSetup {

	@Bean
	public TododbApplication createApplication() {
		return new TododbApplicationBuilder().withPassword("root")
				.withParam("db.mysql.collationName", "utf8mb4_general_ci")
				.withParam("db.mysql.binaryCollationName", "utf8mb4_bin").withLogging(LogType.APPLICATION_BUILDER)
				.withLogging(LogType.STREAM).withLogging(LogType.STREAM_OPTIMIZER).withLogging(LogType.PERSIST)
				.withLogging(LogType.REMOVE).withLogging(LogType.UPDATE).build();
	}

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		return new Jackson2ObjectMapperBuilder().indentOutput(true);
	}
}

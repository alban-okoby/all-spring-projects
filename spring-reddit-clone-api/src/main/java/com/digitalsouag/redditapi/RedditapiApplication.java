package com.digitalsouag.redditapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditapiApplication.class, args);
	}

}

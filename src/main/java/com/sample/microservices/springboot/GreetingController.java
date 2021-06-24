package com.sample.microservices.springboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	// Default --
	@GetMapping("/")
	public Greeting greeting() {

		return new Greeting(counter.incrementAndGet(), String.format(template, "World From Java Spring Boot!"));
	}

	// Query Params --
	@GetMapping("/hello")
	public Greeting greetingWithQueryParams(@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(counter.incrementAndGet(), String.format(template, name + " From Java Spring Boot!"));
	}

	// Url Params --
	@GetMapping("/hello/{name}")
	public Greeting greetingWithUrlParams(@PathVariable(value = "name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name + " From Java Spring Boot!"));
	}

}

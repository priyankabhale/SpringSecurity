package com.spring.boot.security.demo.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/") // root URL
	public String home() {
		return ("<h1> Welcome HOME</h1>");
	}

	@GetMapping("/admin")
	public String admin() {
		return ("<h1> Welcome ADMIN</h1>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1> Welcome USER</h1>");
	}
}

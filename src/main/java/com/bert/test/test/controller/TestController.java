package com.bert.test.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test")
public class TestController {
	@GetMapping(value = "/test1")
	public String ciccio() {
		return "Ciccio";
	}
}

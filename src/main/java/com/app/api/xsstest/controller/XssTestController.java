package com.app.api.xsstest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.xsstest.dto.XssTestDto;

@RestController
@RequestMapping("/xss")
public class XssTestController {

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // consumes 로 들어오는 데이터 타입 정의
	public XssTestDto xssTest1(XssTestDto xssTestDto) {
		return xssTestDto;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public XssTestDto xssTest2(@RequestBody XssTestDto xssTestDto) {
		return xssTestDto;
	}

}

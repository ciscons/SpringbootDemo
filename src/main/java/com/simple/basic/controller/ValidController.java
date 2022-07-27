package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {
	
	@GetMapping("/view")
	public void view() {
	}
	
	// vo에 유효성 검사를 진행하고, 실패하면 Errors 객체로 바인딩 된다.
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors ) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			System.out.println(list);
		}
		
		
		return "valid/result"; //유효성검사를 성공시 나가는화면
	}
	
}

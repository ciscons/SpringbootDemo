package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.QuizVO;
import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {
	
	@GetMapping("/view")
	public void view() {
	}
	
	// vo에 유효성 검사를 진행하고, 실패하면 Errors 객체로 바인딩 된다.
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors, Model model ) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
//			System.out.println(list);
			
			for(FieldError err : list) {
//				System.out.println("실패한 필드명: " + err.getField());
//				System.out.println("실패한 필드의 메시지: " + err.getDefaultMessage());
//				System.out.println("바인딩 실패 여부: " + err.isBindingFailure()); // data type이 달라서 아예 검사조차 되지 않은 경우
				
				if(err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "형식을 일치시키세요");
				}else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
			model.addAttribute("vo", vo);
			return "valid/view"; //유효성검사를 성공시 나가는화면
		}
		return "valid/result"; //유효성검사를 성공시 나가는화면
	}
	
	@GetMapping("/quiz01")
	public void quiz01() {
	}
	// vo에 유효성 검사를 진행하고, 실패하면 Errors 객체로 바인딩 된다.
	@PostMapping("/quizForm")
	public String quizForm(@Valid QuizVO vo, Errors errors, Model model ) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err : list) {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
					System.out.println("바인딩 실패 여부: " + err.isBindingFailure());
			}
			model.addAttribute("vo", vo);
			return "valid/quiz01"; //유효성 검사를 성공시 나가는화면
		}
		return "valid/quiz01_result"; //유효성 검사를 성공시 나가는화면
	}

}

package com.simple.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UserVO;

@Controller
@RequestMapping("/user")
public class SessionController {
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//Post 방식의 login은 이쪽으로 넘어온다. 오버로딩의 개념임
	@PostMapping("/login")
	public String loginForm(UserVO vo, HttpServletRequest request) {
		//vo를 가지고 로그인 sql을 실행
		//이게 로그인에서 가장 많이 쓰는 폼이다
		//select * from 유저 where id = ? and pw = ?
		
//		로그인은 권한이라는 개념도 포함되기 때문에 직접 만들 일은 많이 없을 것이다.
		//로그인 성공이라 가정한다.
		//다른 페이지에서도 정보를 지속적으로 유지하기 위해 session을 사용한다.
		HttpSession session = request.getSession();
		UserVO user = UserVO.builder().id("홍길동").pw("1234").build();
//		session.setAttribute("식별이름", 값);
		//기본 세팅된 30분 또는 브라우저를 완전히 종료하기 전까지가 life cycle이다.
		session.setAttribute("user", user);		
		
		
		
		return "redirect:/user/success";
	}
	
	@GetMapping("/success")
	public String success(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		}
		
		return "user/success";
	}
	
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		}
		
		return "user/mypage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
	
	
	
}	

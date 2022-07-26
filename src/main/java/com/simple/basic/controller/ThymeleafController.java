package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.BuilderVO2;
import com.simple.basic.command.SimpleVO;

@Controller
@RequestMapping("/view") // 모든 경로의 상위에 /view를 붙여서 사용하게 된다.
public class ThymeleafController {

//	//ex01 화면 출력
//	@GetMapping("/test")
//	public String ex01() {
//		
//		return "view/ex01";
//	}
//	
	//ex02에 대한 화면 출력
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		ArrayList<BuilderVO2> list = new ArrayList<BuilderVO2>();
		
		for(int i = 1; i <= 10; i++) {
			BuilderVO2 vo = BuilderVO2
					       .builder()
					       .name("홍길동" + i)
						   .age(i)
						   .build();
			list.add(vo);
		}
		model.addAttribute("aaa", list);
		model.addAttribute("bbb", "홍길동");
		return "view/ex02";
	}
	
	//quiz01 화면으로 simpleVO를 반복문으로 20개를 리스트에 담아 가져간다.
	//quiz01 화면에 sno 값이 3의 배수일때만 출력 
	// LocalDateTime.now();
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		ArrayList<SimpleVO> list = new ArrayList<SimpleVO>();
		
		for (int i = 1; i <= 20; i++) {
			SimpleVO vo = SimpleVO.builder()
								  .sno(i)
								  .first("테스트" + i + "번 째 ")
								  .last("입니다.")
								  .regdate(LocalDateTime.now())
								  .build();
			list.add(vo);
		}
		
		model.addAttribute("aaa", list);
		
		return "view/quiz01";
	}

	@GetMapping("/ex03")
	public String ex03(Model model) {
ArrayList<SimpleVO> list = new ArrayList<SimpleVO>();
		
		for (int i = 1; i <= 20; i++) {
			SimpleVO vo = SimpleVO.builder()
								  .sno(i)
								  .first("테스트" + i + "번 째 ")
								  .last("입니다.")
								  .regdate(LocalDateTime.now())
								  .build();
			list.add(vo);
		}
		
		model.addAttribute("aaa", list);
		
		return "view/ex03";
	}

}

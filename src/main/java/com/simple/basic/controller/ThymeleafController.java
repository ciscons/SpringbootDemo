package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	// ex02에 대한 화면 출력
	@GetMapping("/ex02")
	public String ex02(Model model) {

		ArrayList<BuilderVO2> list = new ArrayList<BuilderVO2>();

		for (int i = 1; i <= 10; i++) {
			BuilderVO2 vo = BuilderVO2.builder().name("홍길동" + i).age(i).build();
			list.add(vo);
		}
		model.addAttribute("aaa", list);
		model.addAttribute("bbb", "홍길동");
		return "view/ex02";
	}

	// quiz01 화면으로 simpleVO를 반복문으로 20개를 리스트에 담아 가져간다.
	// quiz01 화면에 sno 값이 3의 배수일때만 출력
	// LocalDateTime.now();
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		ArrayList<SimpleVO> list = new ArrayList<SimpleVO>();

		for (int i = 1; i <= 20; i++) {
			SimpleVO vo = SimpleVO.builder().sno(i).first("테스트" + i + "번 째 ").last("입니다.").regdate(LocalDateTime.now())
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
			SimpleVO vo = SimpleVO.builder().sno(i).first("테스트" + i + "번 째 ").last("입니다.").regdate(LocalDateTime.now())
					.build();
			list.add(vo);
		}

		model.addAttribute("aaa", list);

		return "view/ex03";
	}

//	@GetMapping("/result")
////	public String result(HttpServletRequest request) {
////	public String result(@RequestParam("sno") int sno, @RequestParam("first") String first) {
//	public String result(SimpleVO vo) {
//
//		// Get으로부터 값 전달받기 세번째 방법 VO 또는 DTO로 받을 땐 넘어오는 값을 자동으로 property로 바인딩한다.
//		System.out.println(vo.getSno());
//		System.out.println(vo.getFirst());
//		
//		// Get으로부터 값 전달받기 두번째 방법 @ReqeustParam
////		System.out.println(sno + first);
//		
//		// Get으로부터 값 전달받기 첫번째 방법 HttpServletRequest
////		System.out.println("실행됨");
////		int sno = Integer.parseInt(request.getParameter("sno"));
////		String first = request.getParameter("first");
////		
////		System.out.printf("sno = %d, first = %s\n", sno, first);
//		
//		return "view/ex3result";
//	}

	@GetMapping("/result02/{sno}/{first}")
	public String result02(@PathVariable("sno") int sno, @PathVariable("first") String first) {

		// Get으로부터 값 전달받기 네번째 방법, PathVariable로 값 전달 받기, Get에서 전달할 때는 주소 경로에 값을 직접 입력한다.
		System.out.println(sno);
		System.out.println(first);

		return "view/ex3result";
	}

	@GetMapping("/ex04")
	public String ex04(Model model) {

		SimpleVO vo = SimpleVO.builder().sno(10).first("홍").last("길동").regdate(LocalDateTime.now()).build();

		model.addAttribute("vo", vo);
		model.addAttribute("name", "홍길동");
		model.addAttribute("arr", new int[] { 1, 2, 3, 4 });

		return "view/ex04";
	}

	@GetMapping("/ex05")
	public String ex05(Model model) {

		SimpleVO vo = SimpleVO.builder().sno(10).first("홍").last("길동").regdate(LocalDateTime.now()).build();

		model.addAttribute("vo", vo);
		model.addAttribute("name", "홍길동");
		model.addAttribute("arr", Arrays.asList(1,2,3,4));
		model.addAttribute("arr", new int[] { 1, 2, 3, 4 });
		

		return "view/ex05";
	}

	@GetMapping("/quiz02")
	public String quiz02(Model model) {
		
		SimpleVO vo = SimpleVO.builder().sno(10).first("홍길동").regdate(LocalDateTime.now()).build();
		model.addAttribute("vo", vo);
		
		return "view/quiz02";
	}
	
	@GetMapping("/quiz2_result")
//public String result(HttpServletRequest request) {
	public String result(@RequestParam("sno") int sno, @RequestParam("first") String first, Model model) {
//public String result(SimpleVO vo) {

	// Get으로부터 값 전달받기 세번째 방법 VO 또는 DTO로 받을 땐 넘어오는 값을 자동으로 property로 바인딩한다.
//	System.out.println(vo.getSno());
//	System.out.println(vo.getFirst());
	
	// Get으로부터 값 전달받기 두번째 방법 @ReqeustParam
//	System.out.println(sno + first);
	
	// Get으로부터 값 전달받기 첫번째 방법 HttpServletRequest
//	System.out.println("실행됨");
//	int sno = Integer.parseInt(request.getParameter("sno"));
//	String first = request.getParameter("first");
//	
//	System.out.printf("sno = %d, first = %s\n", sno, first);
	
	SimpleVO vo = SimpleVO.builder().sno(sno).first(first).build();
	model.addAttribute("vo", vo);
		
	return "view/quiz2_result";
}
	
	//ex06화면 출력(replace)
	@GetMapping("/ex06")
	public String ex06() {
		return "view/ex06";
	}
	
	//ex07화면 출력(replace)
	@GetMapping("/ex07")
	public String ex07() {
		return "view/ex07";
	}

}

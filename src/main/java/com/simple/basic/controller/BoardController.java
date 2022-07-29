package com.simple.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.BoardVO;
import com.simple.basic.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	// 4. Autowired 사용으로 Bean 생성하여 사용할 수도 있다. 전역 변수 영역에서만 가능하다.
	@Autowired
	BoardService boardService;

	// 등록화면
	@GetMapping("/boardRegist")
	public String boardRegist() {
		return "board/boardRegist";
	}

	// 목록화면
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		return "board/boardList";
	}

	// 결과화면
	@GetMapping("/boardResult")
	public String boardResult() {
		
		System.out.println("redirected");
		
		return "board/boardResult";
	}

	@PostMapping("/boardForm")
	public String boardForm(BoardVO vo) {

		// 1. 근본적인 방법으로 insert
//		BoardServiceImpl boardService = new BoardServiceImpl();
//		boardService.insert(vo);

		// 2. 자식 생성 > 부모 저장하는 방식으로 진행할 수도 있다. / JAVA가 좋아하는 방식임
		// 3. 멤버 변수(전역 변수)로 선언하여 여러 곳에서 사용하게 할수도 있다.
//		BoardService boardService = new BoardServiceImpl();
//		boardService.insert(vo);

		// IoC container의 사용 이유, 미리 만들어둔 것들을 꺼내서 쓴다.

		boolean result = boardService.insert(vo);
		System.out.println("성공 실패 : " + result);
		// 1. 새로고침을 방지하는 방법
		// 화면에 데이터를 가져나갈 필요가 없다면 리다이렉트 방식으로 처리
		// 스프링에서 redirect 방식은 다시 컨트롤러를 태워 보내는 방식이다.
		return "redirect:/board/boardResult"; // 결과화면으로
	}
	
	// 상세화면
	// a 태그로 들어오는 경우 반드시 get 매핑으로만 들어와야 한다.
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("bno") int bno,
							  Model model) {
		
		BoardVO vo = boardService.getDetail(bno);
		model.addAttribute("vo", vo);
		
		return "board/boardDetail";
	}
	
	//글 삭제
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
//		System.out.println(bno);
		// redirect는 그대로 return되는 경로로 지정된 controller method로 이동한다.
		boolean result = boardService.delete(bno);
		System.out.println(result);
		// redirect는 Model 값을 다 버리고 이동시킨다. model 데이터도 함께 이동해야 하는 경우 forward 사용해야 한다.
		// 하지만 RedirectAttributes 를 사용하면 가지고 이동할 수 있다.
		RA.addFlashAttribute("msg", "정상 처리 되었습니다.");
		return "redirect:/board/boardList";
	}
}

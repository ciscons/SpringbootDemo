package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.MemoVO;
import com.simple.basic.service.memo.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	MemoService memoService;

	// 등록화면
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}

	@PostMapping("/memoForm")
	public String memoForm(@Valid MemoVO vo, Errors errors, Model model) {
		if (errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();

			for (FieldError err : list) {
				if (err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "형식을 일치시키세요");
				} else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
			model.addAttribute("vo", vo);
			return "memo/memoWrite";
		}

		boolean result = memoService.insert(vo);
		System.out.println(result);

		return "redirect:/memo/memoList";
	}

	// memo 상세 화면
	@GetMapping("/memoDetail")
	public String memoDetail(@RequestParam("mno") int mno, Model model) {
		MemoVO vo = memoService.getDetail(mno);
		model.addAttribute("vo", vo);
		return "memo/memoDetail";
	}

	// memo 리스트 화면
	@GetMapping("/memoList")
	public String memoList(Model model) {
		List<MemoVO> list = memoService.getList();
		model.addAttribute("list", list);
		return "memo/memoList";
	}

	// 글 삭제
	@GetMapping("/memoDelete")
	public String memoDelete(@RequestParam("mno") int mno, RedirectAttributes RA) {
		boolean result = memoService.delete(mno);
		System.out.println(result);
		RA.addFlashAttribute("msg", "메모가 삭제되었습니다.");
		return "redirect:/memo/memoList";
	}

}

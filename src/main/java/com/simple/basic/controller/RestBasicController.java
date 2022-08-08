package com.simple.basic.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.RestVO;

@RestController //REST 컨트롤러는 rest controller + responseBody 어노테이션이 함께 있다.
public class RestBasicController {
	// consumer : 반드시 이 타입으로 데이터를 달라는 의미 default = JSON
	// produces : 해당 타입으로 응답하겠다는 의미 default = JSON
	@GetMapping(value = "/hello", produces = "text/plain")
	public String hello() {
		return "왜불러?";
	}
	
	// 아무것도 안적었다면 아래와 같이 적용된다.		
	// produces는 default 값으로 json 형식을 가진다.	
	// jackson-data-bind 모듈이 반드시 필요하다. (spring boot에는 기본적으로 포함된다.)
	//	@GetMapping(value = "/getObject", produces="application/json;charset=UTF-8")
	@GetMapping("/getObject")
	public RestVO getObject() {
		return new RestVO(1, "헬로", "test");
	}
	
	@GetMapping(value="/getObject2", produces = "application/json;charset=UTF-8")
	public Map<String, Object> getObject2() {
		Map<String, Object> map = new HashMap<>();
		map.put("data",  new RestVO(1, "헬로", "테스트"));
		return map;
	}
	
	@GetMapping(value="/getObject3", produces = "application/json;charset=UTF-8")
	public List<RestVO> getObject3() {
		List<RestVO> list = new ArrayList<>();
		list.add((new RestVO(1, "헬로", "테스트")));
		list.add((new RestVO(1, "헬로2", "테스트2")));
		return list;
	}
	
	// Get 방식으로 REST API에서 보내는 JSON 데이터를 받는 법
	//데이터를 보내는 첫번째 예시 : localhost:8181/getData?key=홍길동&bno=1
	//RequestParam은 값을 반드시 필수로 보내야 한다. (required 값이 true이기 때문)
	@CrossOrigin("*")
	@GetMapping("/getData")
	public RestVO getData(@RequestParam("key") String key,
						  @RequestParam("bno") int bno) {
		System.out.println(key);
		System.out.println(bno);
		
		return new RestVO(1, "헬로", "테스트");
	}
	
	//데이터를 보내는 두번째 예시 : localhost:8181/getData2/홍길동/1
	//path variable 형식
	@GetMapping("/getData2/{name}/{bno}")
	public RestVO getData2(@PathVariable("name") String name,
						   @PathVariable("bno") int bno) {
		System.out.println(name);
		System.out.println(bno);
		
		return new RestVO(1, "헬로", "테스트");
	}
	
	//Post 방식으로 값 받기
	//1. VO 타입으로 데이터 전달받기
	@CrossOrigin("*")
	@PostMapping("/getJSON")
	public List<RestVO> getJSON(@RequestBody RestVO vo) {
		System.out.println(vo.toString());
		
		List<RestVO> list = new ArrayList<>();
		list.add(new RestVO(1, "홍길동", "3"));
		list.add(new RestVO(1, "이순신", "3"));
		
		return list;
	}
	
	//2. Map을 이용해서 받기
	@PostMapping("/getMap")
	public RestVO getMap(@RequestBody Map<String, Object> map) {
		System.out.println(map.toString());
		return null;
	}
	
	@PostMapping(value="/getText", consumes = "text/plain")
	public RestVO getText(@RequestBody String data) {
		
		System.out.println(data);
		
		return null;
	}
	
	// 커스텀 문서를 직접 보내는 방법
	@PostMapping("/createResponse")
	public ResponseEntity<RestVO> createResponse() {
		
		RestVO vo = new RestVO(1, "헬로", "test");
		HttpHeaders header = new HttpHeaders(); // 헤더
		header.add("Authorization", "json web token");
		ResponseEntity<RestVO> res = new ResponseEntity<>(vo, header, HttpStatus.OK);
		return res;
	}
	
}

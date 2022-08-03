package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.RestVO;

@RestController
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
	
	
}

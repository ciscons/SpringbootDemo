package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO2;


@SpringBootTest
public class TestCode02 {
	
	@Test
	public void test01() {
//		Builder b = BuilderVO.builder();
//		BuilderVO bvo = b.setAge(20).setName("한지민").build();
		
		// 한 줄로 표기 가능
		BuilderVO vo = BuilderVO.builder().setAge(20).setName("한지민").build();
		
		//lombok의 @Builder 어노테이션
		BuilderVO2 vo2 = BuilderVO2.builder().age(20).name("한지민").build();
		
		System.out.println(vo2.toString());
	}
}

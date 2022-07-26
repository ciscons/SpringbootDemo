package com.simple.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor //모든멤버변수를 받는 생성자
@NoArgsConstructor //기본생성자
public class SimpleVO {

	private int sno;
	private String first;
	private String last;
	private LocalDateTime regdate; //시간
}

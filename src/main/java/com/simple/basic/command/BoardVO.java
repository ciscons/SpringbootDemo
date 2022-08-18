package com.simple.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardVO {

	private Integer bno;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regdate;
	//충돌 발생
	//테스트입니다.

}

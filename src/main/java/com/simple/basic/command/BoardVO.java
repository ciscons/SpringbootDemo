package com.simple.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {

	private Integer bno;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regdate;
	
}

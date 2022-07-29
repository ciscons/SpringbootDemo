package com.simple.basic.command;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {

	private Integer mno;
//	@Size(message="메모는 5글자 이상 입력해주세요", min=5)
	@Pattern(message ="메모는 5글자 이상 입력해주세요.", regexp="\\W{5,}||\\w{5,}")
	private String memo;
	@Pattern(message ="연락처는 000-0000-0000 형식으로 입력해주세요.", regexp="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}")
	private String phone;
	@Pattern(message ="비밀번호는 숫자 4자리 입니다.", regexp="[0-9]{4}")
	private String pw;
	private char secret;
	
}

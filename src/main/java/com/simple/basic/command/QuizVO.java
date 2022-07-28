package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizVO {

	// Spring boot에 JPA 라이브러리를 사용하는 경우 기본타입은 null을 사용할 수 없기 때문에 wrapper class를 사용 한다.
	/*
	 * 1. 스프링부트에 JPA라이브러리를 사용하면 기본타입은 null을 저장할 수 없어서 wrapper를 사용합니다.
	 * @NotNull - null은 제외한다( String, 숫자, 실수형에 적용가능 )
	 * @NotBlank - null과 공백 제외한다 (String 에 적용)
	 * @NotEmpty - null은 제외한다 (배열, 리스트 등등에 적용)
	 * @Pattern - 정규 표현식에 알맞은 문자열을 적용할 수 있음 ( String에 적용)
	 */
	
	@Pattern(message="아이디는 영문자,숫자 8자 이상입니다", regexp = "[a-zA-Z0-9]{8,}")
	private String id;

	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,}",
             message = "비밀번호는 영문, 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자리 이상이어야 합니다.")
	private String pw;
}

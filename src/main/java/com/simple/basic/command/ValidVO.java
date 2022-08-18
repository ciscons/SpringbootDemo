package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValidVO {

	// Spring boot에 JPA 라이브러리를 사용하는 경우 기본타입은 null을 사용할 수 없기 때문에 wrapper class를 사용 한다.
	/*
	 * 1. 스프링부트에 JPA라이브러리를 사용하면 기본타입은 null을 저장할 수 없어서 wrapper를 사용합니다.
	 * @NotNull - null은 제외한다( String, 숫자, 실수형에 적용가능 )
	 * @NotBlank - null과 공백 제외한다 (String 에 적용)
	 * @NotEmpty - null은 제외한다 (배열, 리스트 등등에 적용)
	 * @Pattern - 정규 표현식에 알맞은 문자열을 적용할 수 있음 ( String에 적용)
	 */
	
	@NotBlank(message = "이름은 필수입니다.") // 에러 발생 시에 사용할 메시지를 작성
	private String name;
	@NotNull(message = "급여는 필수입니다.")
	private Integer salary;
	@Pattern(message = "000-0000-0000 형식입니다.", regexp = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}")
	private String phone;
	@NotBlank
	@Email(message = "이메일 형식이어야 합니다.")
	private String email;
}

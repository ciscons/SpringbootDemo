package com.simple.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //스프링 설정파일로 선언
public class WebConfig implements WebMvcConfigurer {
	
	//스프링 설정파일로 사용할 클래스 (webmvcconfiguer를 상속받습니다)
	
	//ioc컨테이너 안에 생성된 객체들을 확인할 수 있는 인터페이스
//	@Autowired
//	private ApplicationContext app;
	
	// value의 값을 application.properties에서 url의 값을 가져와서 지정한다.
//	@Value("${spring.url}")
//	private String url;
	
//	@Bean
//	public void test() {
//		System.out.println("IOC컨테이너 빈 개수:" + app.getBeanDefinitionCount());

//		HomeController h = app.getBean(HomeController.class);
//		System.out.println("IOC컨테이너 안에 빈객체:" + h);
//		System.out.println("홈컨트롤러 안에 메서드:" + h.home());

//		UtilComponent w = app.getBean(UtilComponent.class);
//		System.out.println(w.util());
		
		//util메서드 실행.
//		System.out.println("유틸컴포넌트 안에 메서드:" +  utilComponent().util());
		
		//application.properties의 url 값
//		System.out.println(url);
		
//	}
	
//	@Bean //빈으로 생성
//	public UtilComponent utilComponent() {
//		return new UtilComponent();
//	}
	
//	@Bean
//	public BoardServiceImpl boardServiceImpl() {
//		return new BoardServiceImpl();
//	}

}

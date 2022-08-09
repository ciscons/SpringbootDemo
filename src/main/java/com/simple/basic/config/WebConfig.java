package com.simple.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.util.intercepter.UserAuthHandler;

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
	
	///////////////////////////////////////////////////////////////////////////////
	//인터셉트 사용 시 Bean 생성해야 함
	
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( userAuthHandler() ) //인터셉터 등록
		.addPathPatterns("/user/**") //user로 시작하는 모든 경로를 인터셉터에 등록하겠다. 앞을 안적으면 JS 쪽에서도 다 동작해버리게 된다.
		.addPathPatterns("/memo/**") // memo로 시작하는 모든 경로를 인터셉터에 등록하겠다는 뜻.
		.excludePathPatterns("/user/login"); // user/login에서는 intercept 동작이 빠지게 된다.
		
	}
	
	

}

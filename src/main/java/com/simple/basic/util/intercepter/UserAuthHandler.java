package com.simple.basic.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.simple.basic.command.UserVO;

public class UserAuthHandler implements HandlerInterceptor{
	int i = 0;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("유저 인터셉터 실행됨" + i++);
		//세션 검사 작업
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user == null) { //세션이 없다
			//리다이렉트를 지정한다. 안하고 그냥 false만 return하면 아무런 화면도 표시되지 않는다.
			response.sendRedirect( request.getContextPath() + "/user/login"  );
			return false; //컨트롤러를 실행하지 않음
		}else { //세션이 있음
			
			return true; //세션이 있으면 intercepter 통과
		}
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	
}

package kr.co.inter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle::::::::::::::::::::");
		
		HandlerMethod hmethod = (HandlerMethod) handler;
		Method method = hmethod.getMethod();
		System.out.println(hmethod.getBean());
		System.out.println(method); //mvc핸들러가 누군지 알라줌
		
		
		
		return true; // 트루면 정상진행 false 그다음꺼진행 ㄴㄴ
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle:::::::::::::::::::");
		
		Object test = modelAndView.getModel().get("test"); // 맵임 model.add어트리뷰트하면은 오브젝트타입임
		modelAndView.getModel().put("show", "show");
		System.out.println(test);
		System.out.println(modelAndView.getModel().get("show"));
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
}

package kr.co.ca;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		model.addAttribute("serverTime", "hello" );
		
		
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, String name){
//		httpservletrequest requset 파라미터를넣어 request.getparameter를통해 받아올 필요 없이
//		spring에서는 String name파라미터만 넣어도 된다.
//		한글인코딩에 문제가 있어 임시방편으로 method를 만들어 인코딩해준다.
		name = toKor(name);
		
		model.addAttribute("name",name);
		return "insert";
	}
	
	private String toKor(String name) {
		
		try {
			return new String(name.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list() {
		return "list";
	}
	//리턴형식에 void가 있을땐 uri와 같은 views의 jsp를 실행시킨다는것
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public void list2() {}
		
	
}

package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
//method는 안쓰면 기본 get방식
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show() {
		return "show";
	}
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	public String insert(Model model, String name){
//
//		model.addAttribute("name","a");
//		return "insert";
//	}
}

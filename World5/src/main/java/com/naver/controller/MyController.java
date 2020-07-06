package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.utils.Utils;

@Controller
public class MyController {
//value에 {"hello","HELLO"}와 같은 배열을 넣을 수 있다.
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {
		
		return "hello";
	}
	
	@RequestMapping(value = "world", method = RequestMethod.GET)
	public void wrold() {}
	
	@RequestMapping(value = "good", method = RequestMethod.GET)
	public void good(Model model) {
		model.addAttribute("test", "test입니다.");
	}
	
	@RequestMapping(value = "hi", method = RequestMethod.GET)
	public String hi(Model model,String name) {
		name = Utils.toKor(name);
		model.addAttribute("name",name);
		return "hi";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test(String name) {
//		name = Utils.toKor(name);
		System.out.println(name);
	}
	
}

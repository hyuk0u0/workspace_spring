package com.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.domain.LoginDTO;
import kr.co.domain.MarketMemberDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("member")
@SessionAttributes({"login"})  //여러개넣을수있따 모델객체에 바인딩된게 있으면 세션에 바인딩 시켜라!
public class MemberController {

	@Autowired // service인터페이스를 구현한 클래스에 @service어노테이션이 없다면 이곳에 inject/autowired어노테이션이
				// memberservice객체를 가져오지 못한다.
	private MemberService memberService;

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		memberService.insert(dto);

		return "redirect:/member/list";
	}

	// void면 자동적으로 controller에 매핑된 /member+ method에 매핑된 /list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberDTO> list = memberService.list();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(Model model, String id) {
		// String id로 받아도 되지만 MemberDTO로 받아도 된다
		MemberDTO dto = memberService.read(id);
		model.addAttribute("dto", dto);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateui(@PathVariable("id") String id, Model model) {
		MemberDTO dto = memberService.updateui(id);
		model.addAttribute("dto", dto);
		return "member/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto) {
		memberService.update(dto);
	
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") String id, SessionStatus status) {
		memberService.delete(id);
		status.setComplete();
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		
	}
	

	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public String login(LoginDTO login, Model model, HttpSession session) {
		
		MemberDTO dto = memberService.loginpost(login);
		
		if(dto != null) {
			model.addAttribute("login", dto);			
			String path = (String) session.getAttribute("path");
			if (path != null) {
				return "redirect:" + path;
			}
			
			return "redirect:/member/list";
			
			
		} else {
			return "redirect:/member/login";
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		
		return "redirect:/member/list";
	}
	
	
	//////////////////////////////////////////////////////////////////
	


}

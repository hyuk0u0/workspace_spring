package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("member")
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
	
	//void면 자동적으로 controller에 매핑된 /member+  method에 매핑된 /list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberDTO> list = memberService.list();
		model.addAttribute("list", list);
	}
}

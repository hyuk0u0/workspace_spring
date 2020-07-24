package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MarketMemberDTO;
import kr.co.service.MarketMemberService;

@Controller
@RequestMapping("/marketMember")
public class MarketMemberController {
	
	@Autowired
	private MarketMemberService marketMemberService;
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void marketList(Model model) {
		List<MarketMemberDTO> memberList = marketMemberService.memberList();
		model.addAttribute("memberList", memberList);
	}
}

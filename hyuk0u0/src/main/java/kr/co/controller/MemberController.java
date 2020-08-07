package kr.co.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	//아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO memberDTO) {
		return memberService.idChk(memberDTO);
	}
	
	//회원가입 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		
	}
	
	//회원가입
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberDTO memberDTO) {
		
		int idChk = memberService.idChk(memberDTO);
		
		if (idChk == 1) {
			return "/member/register";
		} else if (idChk == 0) {
			memberService.register(memberDTO);
		}
		
		return "redirect:/board/mainPage";
	}
	
	//로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	//로그인
	@RequestMapping(value = )
	
	
}

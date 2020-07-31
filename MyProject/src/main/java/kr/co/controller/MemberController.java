package kr.co.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes({"login"})
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO dto) {
		return memberService.idChk(dto);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberDTO dto) {
		
		int idChk = memberService.idChk(dto);
		
		if (idChk == 1) {
			return "/member/register";
		} else if (idChk == 0) {
			memberService.register(dto);
		}
		
		return "redirect:/board/mainPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto) {
		memberService.update(dto);
		
		return "redirect:/member/myPage/" + dto.getUserId();
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") String userId, SessionStatus status) {
		
		memberService.delete(userId);
		
		status.setComplete();
		
		return "redirect:/board/mainPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String login(LoginDTO login, Model model, HttpSession session) {
		
		LoginDTO dto = memberService.loginPost(login);
		
		if (dto != null) {
			model.addAttribute("login", dto);
			String path = (String) session.getAttribute("path");
			if (path != null) {
				return "redirect:" + path;
			}
			
			return "redirect:/board/mainPage";
		} else {
			return "redirect:/member/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/board/mainPage";
	}
	
	//마이페이지
	@RequestMapping(value = "/myPage/{userId}", method = RequestMethod.GET)
	public String myPage(@PathVariable("userId") String userId, Model model) {
		MemberDTO dto = memberService.myPage(userId);
		
		model.addAttribute("dto", dto);
		
		return "/member/myPage";
	}
	
	// 마이페이지 세션이 없으면 로그인 페이지로
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public void myPage() {
		
	}
}

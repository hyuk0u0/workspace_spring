package kr.co.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes({"login"})
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO memberDTO) {
		return memberService.idChk(memberDTO);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		
	}
	
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
	
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Model model, HttpSession session, RedirectAttributes re) {
		
		LoginDTO login = memberService.loginPost(loginDTO);
		
		if(login != null) {
			model.addAttribute("login", login);
			String path = (String) session.getAttribute("path");
			if (path != null) {
				return "redirect:" + path;
			}
			return "redirect:/board/mainPage";
		} else {
			re.addFlashAttribute("msg", "fail");
			return "redirect:/member/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/board/mainPage";
	}
	
	@RequestMapping(value = "/myPage/{id}", method = RequestMethod.GET)
	public String myPage(@PathVariable("id") String id, Model model) {
		MemberDTO memberDTO = memberService.myPage(id);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "/member/myPage";
	}
	
	// 마이페이지 세션이 없으면 로그인 페이지로
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public void myPage() {
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, RedirectAttributes redirectAttr) throws Exception {
		memberService.update(memberDTO);
		redirectAttr.addFlashAttribute("UpdateMsg", "success");
		return "redirect:/member/myPage/" + memberDTO.getId();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, SessionStatus status, RedirectAttributes redirectAttr) {
		memberService.delete(id);
		
		status.setComplete();
		redirectAttr.addFlashAttribute("deleteMsg", "success");
		return "redirect:/board/mainPage";
	}
	

}

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
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Model model, HttpSession session, RedirectAttributes redirectAttr) {
		LoginDTO login = memberService.loginPost(loginDTO);
		if (login != null) {
			model.addAttribute("login", login);
			String path = (String) session.getAttribute("path");
			if (path != null) {
				System.out.println(path);
				return "redirect:" + path;
			}
			return "redirect:/board/mainPage";
		} else {
			redirectAttr.addFlashAttribute("loginMsg", "fail");
			return "redirect:/member/login";
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/board/mainPage";
	}
	
	//마이페이지
	@RequestMapping(value = "/myPage/{userId}", method = RequestMethod.GET)
	public String myPage(@PathVariable("userId") String userId, Model model) {
		MemberDTO memberDTO = memberService.myPage(userId);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "/member/myPage";
	}
	
	//업데이트 페이지
	@RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
	public String update(@PathVariable("userId") String userId, Model model) {
		MemberDTO memberDTO = memberService.update(userId);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "/member/update";
	}
	
	//업데이트
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO) {
		memberService.updatePost(memberDTO);
		
		return "redirect:/member/myPage/" + memberDTO.getUserId();
	}
	
	//회원탈퇴
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") String userId, SessionStatus status) {
		memberService.delete(userId);
		status.setComplete();
		return "redirect:/board/mainPage";
	}
	
	
}

package kr.co.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dto.BoardDTO;
import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public void mainPage() {
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert (HttpSession session, Model model) {
		LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
		String userId = loginDTO.getUserId();
		MemberDTO memberDTO = boardService.getMember(userId);
		model.addAttribute("memberDTO", memberDTO);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert (BoardDTO dto) {
		
		boardService.insert(dto);
		
		return "redirect:/board/mainPage";
	}
}

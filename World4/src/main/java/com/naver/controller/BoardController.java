package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		
		boardService.insert(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<BoardVO> list = boardService.list();
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable("bno") int bno) {
		BoardVO vo = boardService.read(bno);
		model.addAttribute("vo", vo);
		return "/board/read";
	}
}

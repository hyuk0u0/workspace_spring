package com.naver.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardDTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	private void insert() {
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	private String insert(BoardDTO dto) {
		boardService.insert(dto);
		return "redirect:/board/list";
	}
}

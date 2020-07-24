package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
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
	public void list(Model model, String curPage) {
		
		int page = -1;
		
		if(curPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(curPage);
		}
		
		PageTO<BoardVO> to = new PageTO<BoardVO>(page);
		
		to = boardService.list(to);

		model.addAttribute("to", to);
		model.addAttribute("list", to.getList());
	}
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable("bno") int bno) {
		BoardVO vo = boardService.read(bno);
		model.addAttribute("vo", vo);
		return "/board/read";
	}
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(Model model, @PathVariable("bno") int bno) {
		
		BoardVO vo = boardService.updateUI(bno);
		model.addAttribute("vo", vo);
		
		return "/board/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		
		boardService.update(vo);
		return "redirect:/board/read/" + vo.getBno();
	}
	
	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
	public String delete(@PathVariable("bno") int bno) {
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/searchList", method = RequestMethod.GET)
	public String searchList(Model model, String searchType, String keyword) {
		
		List<BoardVO> list = boardService.searchList(searchType, keyword);
		
		model.addAttribute("list", list);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		
		return "/board/searchList";
	}
}

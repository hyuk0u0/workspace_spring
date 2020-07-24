package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MarketBoardCategoryDTO;
import kr.co.domain.MarketBoardCategoryToyDTO;
import kr.co.service.MarketBoardService;

@Controller
@RequestMapping("/marketBoard")
public class MarketBoardController {
	
	@Inject
	private MarketBoardService marketBoardService;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	private void boardList(Model model) {
		
		List<MarketBoardCategoryDTO> boardList = marketBoardService.boardList();
		model.addAttribute("boardList", boardList);	
	}
	
	@RequestMapping(value = "/boardRead/{bno}", method = RequestMethod.GET)
	public String boardRead(Model model, @PathVariable("bno") int bno) {
		MarketBoardCategoryToyDTO boardCategoryToyDTO = marketBoardService.boardRead(bno);
		model.addAttribute("boardCategoryToyDTO", boardCategoryToyDTO);
		return "/marketBoard/boardRead";
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String purchase(MarketBoardCategoryToyDTO dto) {
		marketBoardService.purchase(dto);
		return "redirect:/marketBoard/boardRead/" + dto.getBno();
	}

}

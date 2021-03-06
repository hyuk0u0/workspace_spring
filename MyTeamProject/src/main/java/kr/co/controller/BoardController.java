package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.AttachDTO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public void mainPage(Model model) {
		List<BoardDTO> boardList = boardService.mainPage();
		List<CategoryDTO> categoryList = boardService.selectCategory();

		model.addAttribute("boardList", boardList);
		
		model.addAttribute("categoryList", categoryList);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(Model model) {
		List<CategoryDTO> categoryList = boardService.categoryList();
		model.addAttribute("categoryList", categoryList);
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectGoods", method = RequestMethod.POST)
	public List<GoodsDTO> selectGoods(CategoryDTO categoryDTO) {
	
		List<GoodsDTO> goodsList = boardService.selectGoods(categoryDTO.getCno());
		
		
		return goodsList;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardDTO boardDTO) {
		boardService.insert(boardDTO);
		return "redirect:/board/mainPage";
	}
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, Model model) {
		BoardDTO boardDTO = boardService.read(bno);
		model.addAttribute("boardDTO", boardDTO);
		return "/board/read";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public void header(Model model) {
		List<CategoryDTO> categoryList = boardService.selectCategory();
		
		model.addAttribute("categoryList", categoryList);
	}
	
}

package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/mainPage")
	public void mainPage() {
		
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
}

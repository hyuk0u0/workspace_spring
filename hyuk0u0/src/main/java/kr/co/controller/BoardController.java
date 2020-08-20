package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	//메인페이지
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public void mainPage(Model model) {
		List<BoardDTO> boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
	}
	
	//관리자페이지
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String adminPage(Model model) {
		List<MemberDTO> memberList = boardService.memberList();
		
		model.addAttribute("memberList", memberList);
		
		return "/board/adminPage";
	}
	
	//카테고리 등록/조회 페이지
	@RequestMapping(value = "/categoryInsert", method = RequestMethod.GET)
	public void categoryInsert(Model model) {
		List<CategoryDTO> categoryList = boardService.categoryList();
		
		model.addAttribute("categoryList", categoryList);
	}
	
	//카테고리 등록
	@RequestMapping(value = "/categoryInsert", method = RequestMethod.POST)
	public String categoryInsert(CategoryDTO categoryDTO, RedirectAttributes redirectAttr) {
		//카테고리 중복확인
		int CategoryChk = boardService.categoryChk(categoryDTO);
		
		if (CategoryChk == 0) {
			boardService.categoryInsert(categoryDTO);
			return "redirect:/board/categoryInsert";
		} else {
			redirectAttr.addFlashAttribute("msg", "중복된 카테고리명 입니다.");
			return "redirect:/board/categoryInsert";
		}
	}
	
	//상품 등록/조회 페이지
	@RequestMapping(value = "/goodsInsert", method = RequestMethod.GET)
	public void goodsInsert(Model model) {
		List<CategoryDTO> categoryList = boardService.categoryList();

		model.addAttribute("categoryList", categoryList);
	}
	
	//상품 등록
	@RequestMapping(value = "/goodsInsert", method = RequestMethod.POST)
	public String goodsInsert(GoodsDTO goodsDTO, RedirectAttributes redirectAttr) {
		//상품 중복확인
		int GoodsChk = boardService.goodsChk(goodsDTO);
		
		if (GoodsChk == 0) {
			boardService.goodsInsert(goodsDTO);
			return "redirect:/board/goodsInsert";
		} else {
			redirectAttr.addFlashAttribute("msg", "중복된 상품명 입니다.");
			return "redirect:/board/goodsInsert";
		}
	}
	
	//상품 리스트 ajax
	@ResponseBody
	@RequestMapping(value = "/selectGoods", method = RequestMethod.POST)
	public List<GoodsDTO> selectGoods(int categoryNum) {
		List<GoodsDTO> goodsList = boardService.goodsList(categoryNum);
		
		return goodsList;
	}
	
	//게시글 페이지
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(Model model) {
		List<CategoryDTO> categoryList = boardService.categoryList();
		
		model.addAttribute("categoryList" ,categoryList);
	}
	
	//게시글 등록
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardDTO boardDTO) {
		String[] files = boardDTO.getFiles();
		
		if(files != null) {
			boardDTO.setFileName(files[0]);			
		}
		
		boardService.insert(boardDTO);
		return "redirect:/board/mainPage";
	}
}

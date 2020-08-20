package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;
import kr.co.domain.MemberDTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	// 카테고리 조회
	@Override
	public List<CategoryDTO> categoryList() {
		return boardDAO.categoryList();
	}
	
	//카테고리 중복확인
	@Override
	public int categoryChk(CategoryDTO categoryDTO) {
		return boardDAO.categoryChk(categoryDTO);
	}
	
	//카테고리 등록
	@Override
	public void categoryInsert(CategoryDTO categoryDTO) {
		boardDAO.categoryInsert(categoryDTO);
	}
	
	//상품 중복확인
	@Override
	public int goodsChk(GoodsDTO goodsDTO) {
		return boardDAO.goodsChk(goodsDTO);
	}
	
	//상품 등록
	@Override
	public void goodsInsert(GoodsDTO goodsDTO) {
		boardDAO.goodsInsert(goodsDTO);
	}
	
	//상품 리스트 ajax
	@Override
	public List<GoodsDTO> goodsList(int categoryNum) {
		return boardDAO.goodsList(categoryNum);
	}
	
	//멤버리스트
	@Override
	public List<MemberDTO> memberList() {
		return boardDAO.memberList();
	}
	
	//게시글 등록
	@Override
	public void insert(BoardDTO boardDTO) {
		boardDAO.insert(boardDTO);
		String[] files = boardDTO.getFiles();
		
		if(files != null) {
			for(String fileName : files) {
				boardDAO.addAttach(fileName, boardDTO.getBoardNum());
			}
		}
	}
	
	//사진 삭제
	@Override
	public void deleteAttachByFileName(String filename) {
		boardDAO.deleteAttachByFileName(filename);
	}
}

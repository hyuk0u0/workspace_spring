package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.AttachDTO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.CategoryGoodsDTO;
import kr.co.domain.GoodsDTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub
		return boardDAO.categoryList();
	}
	
	@Override
	public List<GoodsDTO> selectGoods(int cno) {
		// TODO Auto-generated method stub
		return boardDAO.selectGoods(cno);
	}

	
	@Override
	public void insert(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardDAO.insert(boardDTO);
		String[] files = boardDTO.getFiles();

		if(files != null) {
			for(String filename : files) {
				boardDAO.addAttach(filename, boardDTO.getBno());
			}
		}
		
	}
	
	@Override
	public void deleteAttachByFileName(String filename) {
		// TODO Auto-generated method stub
		boardDAO.deleteAttachByFileName(filename);
	}
	
	@Override
	public List<BoardDTO> mainPage() {
		// TODO Auto-generated method stub
		return boardDAO.mainPage();
	}
	
	@Override
	public BoardDTO read(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.read(bno);
	}
	
	@Override
	public List<CategoryDTO> selectCategory() {
		// TODO Auto-generated method stub
		return boardDAO.selectCategory();
	}
	
	@Override
	public List<String> getAttach(Integer bno) {
		// TODO Auto-generated method stub
		return boardDAO.getAttach(bno);
	}
	

}

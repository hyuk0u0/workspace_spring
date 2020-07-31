package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.CategoryDTO;
import kr.co.domain.CategoryGoodsDTO;
import kr.co.domain.GoodsDTO;
import kr.co.persistence.BoardDAO;

@Service
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

}

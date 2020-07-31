package kr.co.service;

import java.util.List;

import kr.co.domain.CategoryDTO;
import kr.co.domain.CategoryGoodsDTO;
import kr.co.domain.GoodsDTO;

public interface BoardService {

	List<CategoryDTO> categoryList();

	List<GoodsDTO> selectGoods(int cno);

	
	
	
}

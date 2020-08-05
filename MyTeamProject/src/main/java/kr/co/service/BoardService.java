package kr.co.service;

import java.util.List;

import kr.co.domain.AttachDTO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;

public interface BoardService {

	List<CategoryDTO> categoryList();

	List<GoodsDTO> selectGoods(int cno);

	void insert(BoardDTO boardDTO);

	void deleteAttachByFileName(String filename);

	List<BoardDTO> mainPage();

	BoardDTO read(int bno);

	List<CategoryDTO> selectCategory();

	List<String> getAttach(Integer bno);



	
	
	
}

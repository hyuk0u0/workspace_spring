package kr.co.service;

import java.util.List;

import kr.co.domain.MarketBoardCategoryDTO;
import kr.co.domain.MarketBoardCategoryToyDTO;

public interface MarketBoardService {

	List<MarketBoardCategoryDTO> boardList();

	MarketBoardCategoryToyDTO boardRead(int bno);

	List<String> getUpload(Integer bno);

	void purchase(MarketBoardCategoryToyDTO dto);


	
	
}

package kr.co.persistence;

import java.util.List;

import kr.co.domain.MarketBoardCategoryDTO;
import kr.co.domain.MarketBoardCategoryToyDTO;

public interface MarketBoardDAO {

	List<MarketBoardCategoryDTO> boardList();

	MarketBoardCategoryToyDTO boardRead(int bno);

	List<String> getUpload(Integer bno);

	void purchase(MarketBoardCategoryToyDTO dto);


}

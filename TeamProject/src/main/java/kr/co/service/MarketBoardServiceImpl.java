package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MarketBoardCategoryDTO;
import kr.co.domain.MarketBoardCategoryToyDTO;
import kr.co.persistence.MarketBoardDAO;

@Service
public class MarketBoardServiceImpl implements MarketBoardService {
	
	@Inject
	private MarketBoardDAO marketBoardDAO;
	
	@Override
	public List<MarketBoardCategoryDTO> boardList() {
	
		return marketBoardDAO.boardList();
	}
	
	@Override
	public MarketBoardCategoryToyDTO boardRead(int bno) {
		// TODO Auto-generated method stub
		return marketBoardDAO.boardRead(bno);
	}
	
	@Override
	public List<String> getUpload(Integer bno) {
		// TODO Auto-generated method stub
		return marketBoardDAO.getUpload(bno);
	}
	
	@Override
	public void purchase(MarketBoardCategoryToyDTO dto) {
		
		marketBoardDAO.purchase(dto);
		
	}
}

package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardDTO;
import kr.co.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insert(BoardDTO dto) {
		boardDAO.insert(dto);
		
	}
	
	
}

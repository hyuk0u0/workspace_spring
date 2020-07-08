package kr.co.service;

import java.util.List;

import kr.co.domain.BoardDTO;

public interface BoardService {
	
	void insert(BoardDTO dto);

	List<BoardDTO> list();
}

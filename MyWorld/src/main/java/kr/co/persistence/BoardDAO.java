package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardDTO;

public interface BoardDAO {
	
	void insert(BoardDTO dto);

	List<BoardDTO> list();
}

package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardDAO {
	
	void insert(BoardVO vo);

	List<BoardVO> list();

	BoardVO read(int bno);

	void increaseViewcnt(int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);
}

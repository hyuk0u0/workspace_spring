package kr.co.persistence;

import java.util.List;

import kr.co.domain.ReplyVO;

public interface ReplyDAO {

	int insert(ReplyVO vo);
	
	List<ReplyVO> list(int bno);

	int update(ReplyVO vo);

	int delete(int rno);

	void deleteByBno(int bno);
}

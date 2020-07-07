package kr.co.persistence;

import java.util.List;

import kr.co.domain.ReplyVO;

public interface ReplyDAO {

	int insert(ReplyVO vo);
	
	List<ReplyVO> list(int bno);
}

package kr.co.service;

import java.util.List;

import kr.co.domain.ReplyVO;

public interface ReplyService {

	int insert(ReplyVO vo);
	
	List<ReplyVO> list(int bno);

	int update(ReplyVO vo);

	int delete(int rno);
}

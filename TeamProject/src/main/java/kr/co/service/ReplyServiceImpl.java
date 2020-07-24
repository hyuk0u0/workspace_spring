package kr.co.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Override
	public int insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyDAO.insert(vo);
	}
	
	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return replyDAO.list(bno);
	}
	
	@Override
	public int update(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyDAO.update(vo);
	}
	
	
	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return replyDAO.delete(rno);
	}
	
}

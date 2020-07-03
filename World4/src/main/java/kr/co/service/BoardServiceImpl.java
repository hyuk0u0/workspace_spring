package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insert(BoardVO vo) {
		boardDAO.insert(vo);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}
	
	@Override
	public BoardVO read(int bno) {
		boardDAO.increaseViewcnt(bno); // 조회수 늘리기!
		return boardDAO.read(bno);
	}
	
	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.updateUI(bno);
	}
	
	@Override
	public void update(BoardVO vo) {
		boardDAO.update(vo);
		
	}
	
	@Override
	public void delete(int bno) {
		boardDAO.delete(bno);
		
	}
}

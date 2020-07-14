package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.ReplyDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Override
	public void insert(BoardVO vo) {
		boardDAO.insert(vo);
		
		String[] files = vo.getFiles();
		if(files != null) {
			for (String fullname : files) {
				boardDAO.addAttach(fullname, vo.getBno());
			}
		}
		
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
		
		boardDAO.deleteByBno(vo.getBno());
		
		String[] files = vo.getFiles();
		if(files != null) {
			for (String fullname : files) {
				boardDAO.addAttach(fullname, vo.getBno());
			}
		}
	}
	
	@Override
	public void delete(int bno) {
		replyDAO.deleteByBno(bno);
		
		boardDAO.deleteByBno(bno);
		
		boardDAO.delete(bno);
		
	}
	
	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		// TODO Auto-generated method stub
		return boardDAO.list(to);
	}
	
	@Override
	public List<BoardVO> searchList(String searchType, String keyword) {
		// TODO Auto-generated method stub
		return boardDAO.searchList(searchType, keyword);
	}
	
	@Override
	public List<String> getAttach(Integer bno) {
		// TODO Auto-generated method stub
		return boardDAO.getAttach(bno);
	}
	
	@Override
	public void deleteAttachByFileName(String filename) {
		boardDAO.deleteAttachByFileName(filename);
		
	}
}

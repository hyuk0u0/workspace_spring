package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dao.BoardDAO;
import kr.co.dto.BoardDTO;
import kr.co.dto.MemberDTO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void deleteAttachByFileName(String filename) {
		boardDAO.deleteAttachByFileName(filename);
		
	}
	
	@Override
	public void insert(BoardDTO dto) {
		boardDAO.insert(dto);
		
		String[] files = dto.getFiles();
		if(files != null) {
			for(String filename : files) {
				boardDAO.addAttach(filename, dto.getBno());
			}
		}
	}
	
	@Override
	public MemberDTO getMember(String userId) {
		// TODO Auto-generated method stub
		return boardDAO.getMember(userId);
	}
}

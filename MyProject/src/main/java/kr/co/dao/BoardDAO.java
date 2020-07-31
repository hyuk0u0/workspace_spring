package kr.co.dao;

import kr.co.dto.BoardDTO;
import kr.co.dto.MemberDTO;

public interface BoardDAO {

	void deleteAttachByFileName(String filename);

	void insert(BoardDTO dto);

	void addAttach(String filename, int bno);

	MemberDTO getMember(String userId);

}

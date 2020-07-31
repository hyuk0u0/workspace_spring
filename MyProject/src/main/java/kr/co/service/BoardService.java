package kr.co.service;

import kr.co.dto.BoardDTO;
import kr.co.dto.MemberDTO;

public interface BoardService {

	void deleteAttachByFileName(String filename);

	void insert(BoardDTO dto);

	MemberDTO getMember(String userId);

}

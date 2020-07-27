package kr.co.dao;

import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;

public interface MemberDAO {
	
	
	int idChk(MemberDTO dto);
	
	void register(MemberDTO dto);
	
	void update(MemberDTO dto);

	MemberDTO loginPost(LoginDTO login);

	MemberDTO myPage(String userId);

	void delete(String userId);
}

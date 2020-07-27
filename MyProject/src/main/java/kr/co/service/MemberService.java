package kr.co.service;

import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;

public interface MemberService {
	
	int idChk(MemberDTO dto);
	
	void register(MemberDTO dto);
	
	void update(MemberDTO dto);
	
	MemberDTO loginPost(LoginDTO login);

	MemberDTO myPage(String userId);

	void delete(String userId);
}

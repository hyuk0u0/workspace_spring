package kr.co.service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public interface MemberService {

	int idChk(MemberDTO memberDTO);

	void register(MemberDTO memberDTO);

	LoginDTO loginPost(LoginDTO loginDTO);

	MemberDTO myPage(String id);

	void update(MemberDTO memberDTO);

	void delete(String id);

}

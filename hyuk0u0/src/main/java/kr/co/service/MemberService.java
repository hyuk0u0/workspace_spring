package kr.co.service;

import kr.co.domain.MemberDTO;

public interface MemberService {
	
	//아이디 중복확인
	int idChk(MemberDTO memberDTO);
	
	//회원가입
	void register(MemberDTO memberDTO);

}

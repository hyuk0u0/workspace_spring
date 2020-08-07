package kr.co.persistence;

import kr.co.domain.MemberDTO;

public interface MemberDAO {
	
	//아이디 중복체크
	int idChk(MemberDTO memberDTO);
	
	//회원가입
	void register(MemberDTO memberDTO);

}

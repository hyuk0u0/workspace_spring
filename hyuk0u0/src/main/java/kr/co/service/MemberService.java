package kr.co.service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public interface MemberService {
	
	//아이디 중복확인
	int idChk(MemberDTO memberDTO);
	
	//회원가입
	void register(MemberDTO memberDTO);
	
	//로그인
	LoginDTO loginPost(LoginDTO loginDTO);
	
	//마이페이지
	MemberDTO myPage(String userId);
	
	//업데이트페이지
	MemberDTO update(String userId);
	
	//업데이트
	void updatePost(MemberDTO memberDTO);
	
	//회원탈퇴
	void delete(String userId);

}
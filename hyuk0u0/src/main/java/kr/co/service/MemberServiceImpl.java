package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	//아이디 중복확인
	@Override
	public int idChk(MemberDTO memberDTO) {
		return memberDAO.idChk(memberDTO);
	}
	
	//회원가입
	@Override
	public void register(MemberDTO memberDTO) {
		memberDAO.register(memberDTO);
	}
	
	// 로그인
	@Override
	public LoginDTO loginPost(LoginDTO loginDTO) {
		return memberDAO.loginPost(loginDTO);
	}
	
	//마이페이지
	@Override
	public MemberDTO myPage(String userId) {
		// TODO Auto-generated method stub
		return memberDAO.myPage(userId);
	}
	
	//업데이트페이지
	@Override
	public MemberDTO update(String userId) {
		return memberDAO.update(userId);
	}
	
	//업데이트
	@Override
	public void updatePost(MemberDTO memberDTO) {
		memberDAO.updatePost(memberDTO);
	}
	
	//회원탈퇴
	@Override
	public void delete(String userId) {
		memberDAO.delete(userId);
		
	}
}

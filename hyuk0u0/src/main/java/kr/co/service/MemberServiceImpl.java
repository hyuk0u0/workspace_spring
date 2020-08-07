package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
}

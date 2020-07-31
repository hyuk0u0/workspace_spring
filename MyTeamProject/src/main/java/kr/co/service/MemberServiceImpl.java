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
	
	@Override
	public int idChk(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return memberDAO.idChk(memberDTO);
	}
	
	@Override
	public void register(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		memberDAO.register(memberDTO);
	}
	
	@Override
	public LoginDTO loginPost(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return memberDAO.loginPost(loginDTO);
	}
	
	@Override
	public MemberDTO myPage(String id) {
		// TODO Auto-generated method stub
		return	memberDAO.myPage(id);
	}
	
	@Override
	public void update(MemberDTO memberDTO) {
		memberDAO.update(memberDTO);
		
	}
	
	@Override
	public void delete(String id) {
		memberDAO.delete(id);
		
	}
}

package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public int idChk(MemberDTO dto) {
		// TODO Auto-generated method stub
		return memberDAO.idChk(dto);
	}
	
	@Override
	public void register(MemberDTO dto) {
		memberDAO.register(dto);
	}
	
	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberDAO.update(dto);
	}
	
	@Override
	public LoginDTO loginPost(LoginDTO login) {
		// TODO Auto-generated method stub
		return memberDAO.loginPost(login);
	}
	
	@Override
	public MemberDTO myPage(String userId) {
		// TODO Auto-generated method stub
		return memberDAO.myPage(userId);
	}
	
	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		memberDAO.delete(userId);
	}
}

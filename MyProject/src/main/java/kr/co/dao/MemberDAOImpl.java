package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "m.e.m";
	
	@Override
	public int idChk(MemberDTO dto) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".idChk", dto);
	}
	
	@Override
	public void register(MemberDTO dto) {
		// TODO Auto-generated method stub
		session.insert(NS + ".register", dto);
	}
	
	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		session.update(NS + ".update", dto);
	}
	
	@Override
	public LoginDTO loginPost(LoginDTO login) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".loginPost", login);
	}
	
	@Override
	public MemberDTO myPage(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".myPage", userId);
	}
	
	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		session.delete(NS + ".delete", userId);
	}
}

package kr.co.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "m.e.m";
	
	@Override
	public int idChk(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".idChk", memberDTO);
	}
	
	@Override
	public void register(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		session.insert(NS + ".register", memberDTO);
	}
	
	@Override
	public LoginDTO loginPost(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".loginPost", loginDTO);
	}
	
	@Override
	public MemberDTO myPage(String id) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".myPage", id);
	}
	
	@Override
	public void update(MemberDTO memberDTO) {
		session.update(NS + ".update", memberDTO);
	}
	
	@Override
	public void delete(String id) {
		session.delete(NS + ".delete", id);
		
	}
}

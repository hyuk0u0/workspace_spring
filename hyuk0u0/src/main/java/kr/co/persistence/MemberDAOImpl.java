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
	
	//아이디 중복확인
	@Override
	public int idChk(MemberDTO memberDTO) {
		return session.selectOne(NS + ".idChk", memberDTO);
	}
	
	//회원가입
	@Override
	public void register(MemberDTO memberDTO) {
		session.insert(NS + ".register", memberDTO);
		
	}
	
	//로그인
	@Override
	public LoginDTO loginPost(LoginDTO loginDTO) {
		return session.selectOne(NS + ".loginPost", loginDTO);
	}
	
	//마이페이지
	@Override
	public MemberDTO myPage(String userId) {
		return session.selectOne(NS + ".myPage", userId);
	}
	
	//업데이트페이지
	@Override
	public MemberDTO update(String userId) {
		return session.selectOne(NS + ".update", userId);
	}
	
	//업데이트
	@Override
	public void updatePost(MemberDTO memberDTO) {
		session.update(NS + ".updatePost", memberDTO);
	}
	
	//회원탈퇴
	@Override
	public void delete(String userId) {
		session.delete(NS + ".delete", userId);
	}
	
	
}

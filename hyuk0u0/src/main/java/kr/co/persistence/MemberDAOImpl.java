package kr.co.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
}

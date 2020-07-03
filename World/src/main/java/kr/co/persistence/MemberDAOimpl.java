package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberDTO;

@Repository
public class MemberDAOimpl implements MemberDAO {
	
	@Inject
	private SqlSession session;
	
	
	private final String NS="m.e.m";
	
	@Override
	public void insert(MemberDTO dto) {
		session.insert(NS+".insert", dto);

	}
	
	@Override
	public List<MemberDTO> list() {
	
		return session.selectList(NS+".list");
		
		//selectlist selectone 
	}
}

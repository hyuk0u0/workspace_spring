package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MarketMemberDTO;

@Repository
public class MarketMemberDAOImpl implements MarketMemberDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS="m.m.e";
	
	@Override
	public List<MarketMemberDTO> memberList() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".memberList");
	}
}

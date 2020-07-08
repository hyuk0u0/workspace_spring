package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";
	
	@Override
	public void insert(BoardDTO dto) {
		Integer bno = session.selectOne(NS + ".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		
		dto.setBno(bno);
		
		session.insert(NS + ".insert", dto);
	}
	
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".list");
	}
}

package kr.co.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private String NS = "b.o.d";
	
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
}

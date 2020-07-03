package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";
	
	@Override
	public void insert(BoardVO vo) {
		Integer bno = session.selectOne(NS + ".getBno");
		if(bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		
		vo.setBno(bno);
		
		session.insert(NS + ".insert", vo);
		
	}
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".list");
	}
	
	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".read", bno);
	}
	
	@Override
	public void increaseViewcnt(int bno) {
		
		session.update(NS + ".increaseViewcnt", bno);
		
	}
	
	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".updateUI", bno);
	}
	
	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		session.update(NS + ".update", vo);
	}
}

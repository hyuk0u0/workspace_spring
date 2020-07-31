package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CategoryDTO;
import kr.co.domain.CategoryGoodsDTO;
import kr.co.domain.GoodsDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";
	
	@Override
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".categoryList");
	}
	
	@Override
	public List<GoodsDTO> selectGoods(int cno) {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".selectGoods", cno);
	}

	
}

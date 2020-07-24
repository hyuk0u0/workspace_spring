package kr.co.persistence;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MarketBoardCategoryDTO;
import kr.co.domain.MarketBoardCategoryToyDTO;

@Repository
public class MarketBoardDAOImpl implements MarketBoardDAO {
	
	@Inject
	private SqlSession session;
	
	private String NS = "m.b.o";
	
	@Override
	public List<MarketBoardCategoryDTO> boardList() {
		return session.selectList(NS + ".boardList");
	}
	
	@Override
	public MarketBoardCategoryToyDTO boardRead(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".boardRead", bno);
	}
	
	@Override
	public List<String> getUpload(Integer bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".getUpload", bno);
	}
	
	@Override
	public void purchase(MarketBoardCategoryToyDTO dto) {
		Integer pno = session.selectOne(NS + ".getPno");
		if(pno != null ) {
			pno += 1;
		} else {
			pno = 1;
		}
		
		dto.setPno(pno);
		
		StringBuffer temp = new StringBuffer();
		Random random = new Random();
		String randomStr = String.valueOf(random.nextInt(10));
		for (int i = 0; i < 10; i++) {
			temp.append(randomStr);
		}
		
		dto.setDeliveryCode(temp.toString());
		
		session.insert(NS + ".purchase", dto);
		
	}
}

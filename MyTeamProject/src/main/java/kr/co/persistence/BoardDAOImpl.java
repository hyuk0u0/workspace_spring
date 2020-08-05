package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.AttachDTO;
import kr.co.domain.BoardDTO;
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
	
	
	@Override
	public void insert(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		
		Integer bno = session.selectOne(NS + ".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		
		boardDTO.setBno(bno);
		
		session.insert(NS + ".insert", boardDTO);
	}

	@Override
	public void deleteAttachByFileName(String filename) {
		// TODO Auto-generated method stub
		session.delete(NS + ".deleteAttachByFileName", filename);
	}
	
	@Override
	public void addAttach(String filename, int bno) {
		// TODO Auto-generated method stub
		Integer uno = session.selectOne(NS + ".getUno");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uno", uno);
		map.put("filename", filename);
		map.put("bno", bno);
		session.insert(NS + ".addAttach", map);
	}
	
	@Override
	public List<BoardDTO> mainPage() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".mainPage");
	}
	
	@Override
	public BoardDTO read(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".read", bno);
	}
	
	@Override
	public List<CategoryDTO> selectCategory() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".selectCategory");
	}
	
	@Override
	public List<String> getAttach(Integer bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".getAttach", bno);
	}
	

}

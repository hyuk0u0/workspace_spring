package kr.co.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dto.BoardDTO;
import kr.co.dto.MemberDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	public SqlSession session;
	
	private final String NS = "b.o.a";
	
	@Override
	public void deleteAttachByFileName(String filename) {
		session.delete(NS + ".deleteAttachByFileName", filename);
		
	}
	
	@Override
	public void insert(BoardDTO dto) {
		Integer bno = session.selectOne(NS + ".getBno");
		if(bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		
		dto.setBno(bno);
		
		session.insert(NS + ".insert", dto);
		
	}
	
	@Override
	public void addAttach(String filename, int bno) {
		Integer ano = session.selectOne(NS + ".getAno");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ano", ano);
		map.put("filename", filename);
		map.put("bno", bno);
		session.insert(NS + ".addAttach", map);
		
		
	}
	
	@Override
	public MemberDTO getMember(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".getMember", userId);
	}
	

}
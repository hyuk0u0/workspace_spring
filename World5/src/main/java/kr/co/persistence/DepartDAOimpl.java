package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.DepartDTO;

@Repository
public class DepartDAOimpl implements DepartDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "d.e.p";
	
	@Override
	public void insert(DepartDTO dto) {
		session.insert(NS+".insert", dto);
	}
	
	@Override
	public List<DepartDTO> insert() {
		return session.selectList(NS+".list");
	}
	
	@Override
	public DepartDTO read(String did) {
	
		return session.selectOne(NS + ".read", did);
	}
	
	@Override
	public DepartDTO updateui(String did) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".updateui", did);
	}
	
	@Override
	public void update(DepartDTO dto) {
		session.update(NS + ".update", dto);
		
	}
	
	@Override
	public void delete(String did) {
		session.delete(NS + ".delete", did);
		
	}
}

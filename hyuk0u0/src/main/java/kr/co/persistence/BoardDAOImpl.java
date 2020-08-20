package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardDTO;
import kr.co.domain.CategoryDTO;
import kr.co.domain.GoodsDTO;
import kr.co.domain.MemberDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";
	
	//카테고리 조회
	@Override
	public List<CategoryDTO> categoryList() {
		return session.selectList(NS + ".categoryList");
	}
	
	//카테고리 중복확인
	@Override
	public int categoryChk(CategoryDTO categoryDTO) {
		return session.selectOne(NS + ".categoryChk", categoryDTO);
	}
	
	//카테고리 등록
	@Override
	public void categoryInsert(CategoryDTO categoryDTO) {
		//카테고리 번호 ++
		int categoryNum = session.selectOne(NS + ".getCategoryNum");
		categoryDTO.setCategoryNum(categoryNum);
		
		session.insert(NS + ".categoryInsert", categoryDTO);
	}
	
	//상품 중복확인
	@Override
	public int goodsChk(GoodsDTO goodsDTO) {
		return session.selectOne(NS + ".goodsChk", goodsDTO);
	}
	
	//상풍 등록
	@Override
	public void goodsInsert(GoodsDTO goodsDTO) {
		//상품 번호 ++
		int goodsNum = session.selectOne(NS + ".getGoodsNum");
		goodsDTO.setGoodsNum(goodsNum);
		
		session.insert(NS + ".goodsInsert", goodsDTO);
	}
	
	//상품 리스트 ajax
	@Override
	public List<GoodsDTO> goodsList(int categoryNum) {
		return session.selectList(NS + ".goodsList", categoryNum);
	}
	
	//멤버 리스트
	@Override
	public List<MemberDTO> memberList() {
		return session.selectList(NS + ".memberList");
	}
	
	//게시글 등록
	@Override
	public void insert(BoardDTO boardDTO) {
		int boardNum = session.selectOne(NS + ".getBoardNum");
		boardDTO.setBoardNum(boardNum);
		session.insert(NS + ".insert", boardDTO);
	}
	
	//사진 저장
	@Override
	public void addAttach(String fileName, int boardNum) {
		int attachNum = session.selectOne(NS + ".getAttachNum");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attachNum", attachNum);
		map.put("fileName", fileName);
		map.put("boardNum", boardNum);
		session.insert(NS + ".addAttach", map);
		
	}
	
	@Override
	public void deleteAttachByFileName(String filename) {
		session.delete(NS + ".deleteAttachByFileName", filename);
	}
}

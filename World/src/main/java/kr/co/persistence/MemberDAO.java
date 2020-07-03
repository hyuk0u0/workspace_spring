package kr.co.persistence;

import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberDAO {

	void insert(MemberDTO dto);

	List<MemberDTO> list();

}

package kr.co.service;

import java.util.List;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public interface MemberService {

	void insert(MemberDTO dto);

	List<MemberDTO> list();

	MemberDTO read(String id);

	MemberDTO updateui(String id);

	void update(MemberDTO dto);

	void delete(String id);

	MemberDTO loginpost(LoginDTO login);

}

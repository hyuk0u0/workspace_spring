package kr.co.persistence;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public interface MemberDAO {

	int idChk(MemberDTO memberDTO);

	void register(MemberDTO memberDTO);

	LoginDTO loginPost(LoginDTO loginDTO);

	MemberDTO myPage(String id);

	void update(MemberDTO memberDTO);

	void delete(String id);

}

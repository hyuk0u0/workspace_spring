package kr.co.persistence;

import java.util.List;

import kr.co.domain.MarketMemberDTO;

public interface MarketMemberDAO {

	List<MarketMemberDTO> memberList();
	
	
}

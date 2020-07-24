package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MarketMemberDTO;
import kr.co.persistence.MarketMemberDAO;

@Service
public class MarketMemberServiceImpl implements MarketMemberService {
	
	@Inject
	public MarketMemberDAO marketMemberDAO;
	
	@Override
	public List<MarketMemberDTO> memberList() {
		
		return marketMemberDAO.memberList();
	}
}

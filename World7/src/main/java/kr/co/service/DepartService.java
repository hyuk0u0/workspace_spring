package kr.co.service;

import java.util.List;

import kr.co.domain.DepartDTO;

public interface DepartService {

	void insert(DepartDTO dto);

	List<DepartDTO> list();

	DepartDTO read(String did);

	DepartDTO updateui(String did);

	void update(DepartDTO dto);

	void delete(String did);

}

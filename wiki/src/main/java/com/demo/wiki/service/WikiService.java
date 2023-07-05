package com.demo.wiki.service;

import java.util.List;

import com.demo.wiki.model.Wiki;

public interface WikiService {
	
	long save (Wiki wiki);
	Wiki get(long id);
	List<Wiki> list();
	void update(Long id, Wiki wiki);
	void delete(Long id);

}

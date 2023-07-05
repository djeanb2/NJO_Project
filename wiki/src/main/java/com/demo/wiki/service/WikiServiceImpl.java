package com.demo.wiki.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.wiki.dao.WikiDAO;
import com.demo.wiki.model.Wiki;

@Service
public class WikiServiceImpl implements WikiService{
	
	@Autowired
	private WikiDAO wikiDAO;

	@Override
	public long save(Wiki wiki) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Wiki get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Wiki> list() {
		return wikiDAO.list();
	}

	@Override
	public void update(Long id, Wiki wiki) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

package com.demo.wiki.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.wiki.model.Wiki;

@Repository
public class WikiDAOImpl implements WikiDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

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
	public List<Wiki> list() {
		 List<Wiki> list= sessionFactory.getCurrentSession().createQuery("from wiki").list();
		 return list;
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

package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.model.Registration;

@Repository
public class RegistrationDaoImpl implements RegistrationDao
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addRegistartion(Registration reg)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(reg);
	}
}

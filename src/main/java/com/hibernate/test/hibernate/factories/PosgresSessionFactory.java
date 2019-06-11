package com.hibernate.test.hibernate.factories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PosgresSessionFactory {
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getInstance() {
		if(sessionFactory == null) {
			synchronized (PosgresSessionFactory.class) {
				if(sessionFactory == null) {
					sessionFactory = new Configuration().configure().buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}
}

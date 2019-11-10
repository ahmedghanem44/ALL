package com.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CoffeeExpertSession {
	
	public static Session openSession() {
		Configuration conf = new Configuration();
		conf = conf.configure("hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		return sf.openSession();
	}
}

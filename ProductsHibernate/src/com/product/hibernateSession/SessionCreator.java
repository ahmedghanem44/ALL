package com.product.hibernateSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {
	
	public static Session openProductSession() {
		Configuration conf = new Configuration();
		conf = conf.configure("hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		return sf.openSession();
	}
	
	
	

	}



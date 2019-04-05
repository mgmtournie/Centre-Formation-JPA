package com.fr.adaming.Entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionDB {
	public static SessionFactory factory;

	public static Session getSession() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();

		return session;
	}

}

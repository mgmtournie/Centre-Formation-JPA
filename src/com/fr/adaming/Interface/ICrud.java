package com.fr.adaming.Interface;


import org.hibernate.Session;

public interface ICrud {
	public  void ajouter(Object object,Session session);

	public  void supprimer(Session session);

	public void modification(Object object,Session session);

	public void consultation (Session session);

	
}

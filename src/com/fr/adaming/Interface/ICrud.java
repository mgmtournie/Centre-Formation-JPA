package com.fr.adaming.Interface;


import java.util.List;

import org.hibernate.Session;

public interface ICrud {
	public  void ajouter(Object object,Session session);

	public  void supprimer(Object object,Session session);
	
	public  List rechercher(Object object,Session session);

	public  List consultation (Session session);

	
}

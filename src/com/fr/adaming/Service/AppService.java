package com.fr.adaming.Service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fr.adaming.Entities.Apprenant;
import com.fr.adaming.Interface.ICrud;

public class AppService implements ICrud {

	@Override
	public void ajouter(Object object, Session session) {
		Apprenant cons = (Apprenant) object;
		Transaction t = session.beginTransaction();

		session.persist(cons);
		System.out.println(cons.toString());
		t.commit();
		session.flush();

	}

	@Override
	public void supprimer(Object object, Session session) {
		
		Apprenant cons = (Apprenant) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Apprenant.class);
		cr.add(Restrictions.like("nom", cons.getNom() + "%"));
		cr.add(Restrictions.like("prenom", cons.getPrenom() + "%"));
		List<Apprenant> results = cr.list();
		session.delete(results.get(0));

		System.out.println("retrait effectué");

		t.commit();
		session.flush();
	}

	@Override
	public List consultation(Session session) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Apprenant.class);
		List results = cr.list();
		t.commit();
		session.flush();
	 return results;
	}

	@Override
	public List rechercher(Object object, Session session) {
		// TODO Auto-generated method stub
		Apprenant cons = (Apprenant) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Apprenant.class);
		cr.add(Restrictions.like("nom", cons.getNom() + "%"));
		cr.add(Restrictions.like("prenom", cons.getPrenom() + "%"));
		List<Apprenant> results = cr.list();
		t.commit();
		session.flush();
		return results; 
	}

}
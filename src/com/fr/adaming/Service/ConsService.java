package com.fr.adaming.Service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fr.adaming.Entities.Consultant;
import com.fr.adaming.Interface.ICrud;

public class ConsService implements ICrud {

	@Override
	public void ajouter(Object object, Session session) {
		Consultant cons = (Consultant) object;
		Transaction t = session.beginTransaction();

		session.persist(cons);
		System.out.println(cons.toString());
		t.commit();
		session.flush();

	}

	@Override
	public void supprimer(Object object, Session session) {
		
		Consultant cons = (Consultant) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Consultant.class);
		cr.add(Restrictions.like("nom", cons.getNom() + "%"));
		cr.add(Restrictions.like("prenom", cons.getPrenom() + "%"));
		List<Consultant> results = cr.list();
		session.delete(results.get(0));

		

		t.commit();
		session.flush();
	}

	@Override
	public List consultation(Session session) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Consultant.class);
		List results = cr.list();
		t.commit();
		session.flush();
	 return results;
	}

	@Override
	public List rechercher(Object object, Session session) {
		// TODO Auto-generated method stub
		Consultant cons = (Consultant) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Consultant.class);
		cr.add(Restrictions.like("nom", cons.getNom() + "%"));
		cr.add(Restrictions.like("prenom", cons.getPrenom() + "%"));
		List<Consultant> results = cr.list();
		t.commit();
		session.flush();
		return results; 
	}

}

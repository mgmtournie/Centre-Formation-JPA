package com.fr.adaming.Service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fr.adaming.Entities.CycleFormation;
import com.fr.adaming.Interface.ICrud;

public class CycleFormService implements ICrud {

	@Override
	public void ajouter(Object object, Session session) {
		CycleFormation cy = (CycleFormation) object;
		Transaction t = session.beginTransaction();

		session.persist(cy);
		
		t.commit();
		session.flush();

	}

	@Override
	public void supprimer(Object object, Session session) {

		CycleFormation cy = (CycleFormation) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(CycleFormation.class);
		cr.add(Restrictions.like("titre", cy.getTitre()));

		List<CycleFormation> results = cr.list();
		session.delete(results.get(0));

		

		t.commit();
		session.flush();
	}

	@Override
	public List consultation(Session session) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(CycleFormation.class);
		List results = cr.list();
		t.commit();
		session.flush();
		return results;
	}

	@Override
	public List rechercher(Object object, Session session) {
		// TODO Auto-generated method stub
		CycleFormation cy = (CycleFormation) object;
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(CycleFormation.class);
		cr.add(Restrictions.eq("titre", cy.getTitre()));

		List<CycleFormation> results = cr.list();
		t.commit();
		session.flush();
		return results;
	}

}
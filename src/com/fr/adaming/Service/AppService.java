package com.fr.adaming.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fr.adaming.Entities.Apprenant;
import com.fr.adaming.Entities.ConnectionDB;
import com.fr.adaming.Entities.Consultant;
import com.fr.adaming.Interface.ICrud;

public class AppService implements ICrud {

	Scanner sc1 = new Scanner(System.in);
	@Override
	public void ajouter(Object object, Session session) {
		Apprenant apps = (Apprenant) object;
		Transaction t = session.beginTransaction();

		session.persist(apps);
		System.out.println(toString());
		t.commit();

	}

	@Override
	public void supprimer(Session session) {

		System.out.println("Choisir le nom de l'apprenant");
		String nomSelect = sc1.nextLine();

		System.out.println("Choisir le prenom de l'apprenant");
		String prenomSelect = sc1.nextLine();

		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Apprenant.class);
		cr.add(Restrictions.like("nom", nomSelect + "%"));
		cr.add(Restrictions.like("prenom", prenomSelect + "%"));
		List<Apprenant> results = cr.list();
		session.delete(results.get(0));

		System.out.println("retrait effectué");

		t.commit();
	}

	@Override
	public void modification(Object object, Session session) {
		// TODO Auto-generated method stub

	}



	@Override
	public void consultation( Session session) {
		
			Transaction t= session.beginTransaction(); 
			 
			Criteria cr = session.createCriteria(Apprenant.class);
			List<Apprenant>results = cr.list();
			System.out.println(results);
			
//			while (resultContainer.next()) {
//				int id1 = resultContainer.getInt("idapprenant"); // ou
//																	// bien
//				String nom1 = resultContainer.getString("nom");
//				String prenom1 = resultContainer.getString("prenom");
//
//				Date dateNai = resultContainer.getDate("dateNaissance",
//						Calendar.getInstance(TimeZone.getTimeZone("UTC")));
//				String diplome = resultContainer.getString("diplome");
//				String cv = resultContainer.getString("cv");
//				int cyForm = resultContainer.getInt("cycleFormation"); // resultContainer.getInt
//				// (2)
//
//				System.out.println(" identifiant:" + id1 + "\tnom: " + nom1 + "\tpr�nom: " + prenom1
//						+ "\tdate de naissance: " + dateNai + "\tdipl�me: " + diplome + "\tcv heure dispo: "
//						+ cv + "\tcycle de formation: " + cyForm);
//
//			}
//		
//		

	}
}
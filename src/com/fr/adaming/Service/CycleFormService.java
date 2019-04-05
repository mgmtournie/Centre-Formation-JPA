package com.fr.adaming.Service;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fr.adaming.Entities.Consultant;
import com.fr.adaming.Entities.CycleFormation;
import com.fr.adaming.Interface.ICrud;

public class CycleFormService implements ICrud {

	Scanner sc1 = new Scanner(System.in); // peut poser pb

	@Override
	public void ajouter(Object object, Session session) {
		CycleFormation cf = (CycleFormation) object;
		Transaction t = session.beginTransaction();

		session.persist(cf);
		System.out.println(toString());
		t.commit();

	}

	@Override
	public void supprimer(Session session) {

		System.out.println("Choisir l'identifiant du cycle de formation");
		String idselect = sc1.nextLine();



		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(CycleFormation.class);
		cr.add(Restrictions.like("id", idselect + "%"));
	
		List<Consultant> results = cr.list();
		session.delete(results.get(0));

		System.out.println("retrait effectué");

		t.commit();
	}

	@Override
	public void consultation(Session session) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction(); 
		Criteria cr = session.createCriteria(CycleFormation.class);
		List< Consultant>results = cr.list();
		System.out.println(results);

//		 System.out.println("Enter le debut du titre du livre");
//
//		 String nom = sc1.nextLine();
//
//		
//		 ResultSet resultContainer = ConsService.getconsultation("Select *	FROM consultant ",conn.createStatement());
//		 while (resultContainer.next()) {
//		 int id1 = resultContainer.getInt("idconsultant"); // ou
//		 bien
//		 String nom1 = resultContainer.getString("nom");
//		 String prenom1 = resultContainer.getString("prenom");
//		
//		 Date dateNai = resultContainer.getDate("dateNaissance",
//		 Calendar.getInstance(TimeZone.getTimeZone("UTC")));
//		 String spe1 = resultContainer.getString("spe");
//		 int nbHeure = resultContainer.getInt("nbHeureDispo");
//		 int cyForm = resultContainer.getInt("cycleFormation"); //
//		resultContainer.getInt
//		 (2)
//		
//		 System.out.println(" identifiant:" + id1 + "\tnom: " + nom1 +
//		 "\tpr�nom: " + prenom1
//		 + "\tdate de naissance: " + dateNai + "\tsp�cialit�: " + spe1 +
//		"\tnombre heure dispo: "
//		+ nbHeure + "\tcycle de formation: " + cyForm);

	}

	@Override
	public void modification(Object object, Session session) {
		// TODO Auto-generated method stub

	}

}

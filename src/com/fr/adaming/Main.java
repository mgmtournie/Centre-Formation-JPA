package com.fr.adaming;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.fr.adaming.Entities.Apprenant;
import com.fr.adaming.Entities.ConnectionDB;
import com.fr.adaming.Entities.Consultant;
import com.fr.adaming.Entities.CycleFormation;
import com.fr.adaming.Service.AppService;
import com.fr.adaming.Service.ConsService;
import com.fr.adaming.Service.CycleFormService;

public class Main {

	public static void main(String[] args) throws ParseException, SQLException {

		CycleFormService cyclFormService = new CycleFormService();
		ConsService consService = new ConsService();
		AppService appService = new AppService();

		Session session = ConnectionDB.getSession();
		// Transaction t = session.beginTransaction();
		int Choix;

		do {
			System.out.println("1- Gestion des consultant \n2- Gestion des apprenants \n3- Gestion des cycles");

			System.out.println("Saisir le numéro de service demandé");

			Scanner sc1 = new Scanner(System.in);
			int num = sc1.nextInt();

			switch (num) {
			case 1:
				System.out.println("Vous avez choisi le service de gestion des consultants");

				System.out.println(
						"1- Ajouter un consultant \n2- Supprimer un consultant  \n3- Voir tous les consultant \n4- Rechercher un consultant");

				int cons = sc1.nextInt();

				switch (cons) {
				case 1:

					System.out.println("Vous avez choisi d'ajouter un consultant");

					System.out.println("Veuillez entrer une date de naissance au format yyyy-mm-dd :");
					sc1.nextLine();
					String dn = sc1.nextLine();
					// Date dNaiss = new
					// SimpleDateFormat("yyyy-MM-dd").parse(dn);
					// String dateToStr=
					// DateFormat.getDateInstance().format(dNaiss);
					// java.sql.Date dateToSql=new java.sql.Date(dNaiss);// date
					// pour sql
					// java.sql.Date sqlDate = new
					// java.sql.Date(dNaiss.getTime());

					System.out.println("Veuillez entrer un nom:");
					String nom = sc1.nextLine();

					System.out.println("Veuillez entrer un prénom:");
					String prenom = sc1.nextLine();

					System.out.println("Veuillez entrer une spécialité:");
					String spe = sc1.nextLine();

					System.out.println("Veuillez entrer un nombre d'heures disponibles:");
					int nbHeureDispo = sc1.nextInt();

					Object consultant = new Consultant(dn, nom, prenom, spe, nbHeureDispo);
					consService.ajouter(consultant, session);
					// roberta1
					break;
				case 2:
					System.out.println("Vous avez choisi de supprimer un consultant");
					sc1.nextLine();
					System.out.println("entrer les quatres premieres lettre du nom du consultant");
					String nomSelect = sc1.nextLine();

					System.out.println("Choisir le prenom du consultant");
					String prenomSelect = sc1.nextLine();
					Object conSup = new Consultant(nomSelect, prenomSelect);

					consService.supprimer(conSup, session);
					System.out.println("retrait effectué");
					break;
				case 3:
					System.out.println("Vous avez choisi de consulter la liste des consultants");
					sc1.nextLine();
					List<Consultant> results = consService.consultation(session);
					for (int i = 0; i < results.size(); i++) {

						System.out.println("\nnom: " + results.get(i).getNom() + "\tprénom: "
								+ results.get(i).getPrenom() + "\tdate de naissance: "
								+ results.get(i).getDateNaissance() + "\tspécialité: " + results.get(i).getSpe()
								+ "\tnombre heure dispo: " + results.get(i).getNbHeureDispo());
					}

					break;
				case 4:
					System.out.println("Vous avez choisi de rechercher un consultant");
					sc1.nextLine();
					System.out.println("entrer les quatres premieres lettre du nom du consultant");
					nomSelect = sc1.nextLine();

					System.out.println("Choisir le prenom du consultant");
					prenomSelect = sc1.nextLine();
					Object conRec = new Consultant(nomSelect, prenomSelect);

					results = consService.rechercher(conRec, session);
					System.out.println("\nnom: " + results.get(0).getNom() + "\tprénom: " + results.get(0).getPrenom()
							+ "\tdate de naissance: " + results.get(0).getDateNaissance() + "\tspécialité: "
							+ results.get(0).getSpe() + "\tnombre heure dispo: " + results.get(0).getNbHeureDispo());

					break;
				}
				break;
			case 2:
				System.out.println("Vous avez choisi le service de gestion des apprenants");

				System.out.println("1- Ajouter un apprenant \n2- Supprimer un apprenant  \n3- Voir tous les apprenants \n4- Rechercher un apprenant");
				int app = sc1.nextInt();
				
				switch (app) {
				case 1:
					System.out.println("Vous avez choisi d'ajouter un apprenant");

					System.out.println("Veuillez entrer une date de naissance au format yyyy-mm-dd :");
					sc1.nextLine();
					String dn = sc1.nextLine();
					Date dNaiss = new SimpleDateFormat("yyyy-MM-dd").parse(dn);
					// String dateToStr=
					// DateFormat.getDateInstance().format(dNaiss);
					// java.sql.Date dateToSql=new java.sql.Date(dNaiss);// date
					// pour sql
					java.sql.Date sqlDate = new java.sql.Date(dNaiss.getTime());

					System.out.println("Veuillez entrer un nom:");
					String nom = sc1.nextLine();

					System.out.println("Veuillez entrer un prenom:");
					String prenom = sc1.nextLine();

					System.out.println("Veuillez entrer un diplome:");
					String diplome = sc1.nextLine();

					System.out.println("Veuillez entrer un lien de CV:");
					String cv = sc1.nextLine();

					Object apprenant = new Apprenant(dn, nom, prenom, diplome, cv);
					appService.ajouter(apprenant, session);
					break;

				case 2:
					System.out.println("Vous avez choisi de supprimer un apprenant");
					sc1.nextLine();
					System.out.println("entrer les quatres premieres lettre du nom de l'apprenant");
					String nomSelect = sc1.nextLine();

					System.out.println("Choisir le prenom de l'apprenant");
					String prenomSelect = sc1.nextLine();
					Object appSup = new Apprenant(nomSelect, prenomSelect);
					appService.supprimer(appSup, session);
					break;

				case 3:
					System.out.println("Vous avez choisi de consulter la liste des apprenants");
					sc1.nextLine();
					List<Apprenant> results= appService.consultation(session);
					for (int i = 0; i < results.size(); i++) {

						System.out
								.println(" \nnom: " + results.get(0).getNom() + "\tprénom: " + results.get(0).getPrenom()
										+ "\tdate de naissance: " + results.get(0).getDateNaissance() + "\tCv: "
										+ results.get(0).getCv() + "\tDiplome: " + results.get(0).getDiplome());

					}
					break;

				case 4:
					System.out.println("Vous avez choisi de rechercher un apprenant");
					sc1.nextLine();
					System.out.println("entrer les quatres premieres lettre du nom de l'apprenant");
					nomSelect = sc1.nextLine();

					System.out.println("Choisir le prenom de l'apprenant");
					prenomSelect = sc1.nextLine();
					Object appRec = new Apprenant(nomSelect, prenomSelect);

					results = appService.rechercher(appRec, session);
					System.out.println(" nom: " + results.get(0).getNom() + "\tprénom: " + results.get(0).getPrenom()
							+ "\tdate de naissance: " + results.get(0).getDateNaissance() + "\tCv: "
							+ results.get(0).getCv() + "\tDiplome: " + results.get(0).getDiplome());

					break;

				}

				break;

			case 3:
				System.out.println("Vous avez choisi le service de gestion des Cycles de Formations");

				System.out.println(
						"1- Ajouter un Cycle de formation \n2- Supprimer un Cycle de formation  \n3- Consulter un Cycle de formation");
				int cf = sc1.nextInt();
				switch (cf) {
				case 1:
					System.out.println("Vous avez choisi d'ajouter un Cycle de formation");
					sc1.nextLine();
					System.out.println("Veuillez entrer un titre:");
					String titre = sc1.nextLine();

					System.out.println("Veuillez entrer une description:");
					String description = sc1.nextLine();

					System.out.println("Veuillez entrer un nombre d'heures de formation:");
					int nbHeureForm = sc1.nextInt();
					sc1.nextLine();
					System.out.println("Veuillez entrer une date de debut au format yyyy-mm-dd :");
					String dateDebut = sc1.nextLine();

					Object formation = new CycleFormation(titre, description, nbHeureForm, dateDebut);
					appService.ajouter(formation, session);

					break;
				case 2:
					System.out.println("Vous avez choisi de supprimer un Cycle de formation");
					sc1.nextLine();
					System.out.println("Choisir le titre de la formation");
					String titreSe1 = sc1.nextLine();
					Object formSup = new CycleFormation(titreSe1);

					appService.supprimer(formSup, session);

					break;

							case 3:
					System.out.println("Vous avez choisi de consulter la liste des cycles de formations");
					sc1.nextLine();
					List<CycleFormation> results= cyclFormService.consultation(session);
					for (int i = 0; i < results.size(); i++) {

						System.out.println("\nTitre: " + results.get(0).getTitre() + "\tDescription: " + results.get(0).getDescription()
										+ "\tdate de debut: " + results.get(0).getDateDebut() + "\tNombre d'heure de formation: "
										+ results.get(0).getNbHeureForm());

					}
					break;

				case 4:
					System.out.println("Vous avez choisi de rechercher un cycle de formation");
					sc1.nextLine();
					System.out.println("entrer les quatres premieres lettre du titre");
					titreSe1 = sc1.nextLine();

					Object cfRec = new CycleFormation(titreSe1);

					results = cyclFormService.rechercher(cfRec, session);
					System.out.println("\nTitre: " + results.get(0).getTitre() + "\tDescription: " + results.get(0).getDescription()
							+ "\tdate de debut: " + results.get(0).getDateDebut() + "\tNombre d'heure de formation: "
							+ results.get(0).getNbHeureForm());

					break;

				}

				break;

			}

			System.out.println("entrer votre choix pour continuer \n1-Continuer \n2-Arret");

			Choix = sc1.nextInt();

		} while (Choix == 1);

	}
}

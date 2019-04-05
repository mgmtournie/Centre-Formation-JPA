package com.fr.adaming;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fr.adaming.Entities.ConnectionDB;
import com.fr.adaming.Entities.Consultant;
import com.fr.adaming.Service.AppService;
import com.fr.adaming.Service.ConsService;
import com.fr.adaming.Service.CycleFormService;

public class Main {

	public static void main(String[] args) throws ParseException, SQLException {

		CycleFormService cyclFormService = new CycleFormService();
		ConsService consService = new ConsService();
		AppService appService = new AppService();
		
		Session session = ConnectionDB.getSession(); 
//		Transaction t = session.beginTransaction();
		int Choix;

		do {
			System.out.println("1- Gestion des consultant \n2- Gestion des apprenants \n3- Gestion des cycles");

			System.out.println("Saisir le num�ro de service demand�");
			
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);
			int num = sc1.nextInt();

			switch (num) {
			case 1:
				System.out.println("Vous avez choisi le service de gestion des consultants");

				System.out
						.println("1- Ajouter un consultant \n2- Supprimer un consultant  \n3- Consulter un consultant");

				int cons = sc1.nextInt();

				switch (cons) {
				case 1:

					System.out.println("Vous avez choisi d'ajouter un consultant");

					System.out.println("Veuillez entrer une date de naissance au format yyyy-mm-dd :");
					sc1.nextLine();
					String dn = sc1.nextLine();
					//Date dNaiss = new SimpleDateFormat("yyyy-MM-dd").parse(dn);
					// String dateToStr=
					// DateFormat.getDateInstance().format(dNaiss);
					// java.sql.Date dateToSql=new java.sql.Date(dNaiss);// date
					// pour sql
					//java.sql.Date sqlDate = new java.sql.Date(dNaiss.getTime());

					System.out.println("Veuillez entrer un nom:");
					String nom = sc1.nextLine();

					System.out.println("Veuillez entrer un prénom:");
					String prenom = sc1.nextLine();

					System.out.println("Veuillez entrer une spécialité:");
					String spe = sc1.nextLine();

					System.out.println("Veuillez entrer un nombre d'heures disponibles:");
					int nbHeureDispo = sc1.nextInt();
					
					Object consultant = new Consultant(dn, nom, prenom, spe, nbHeureDispo);
					consService.ajouter(consultant,session);

					break;
				case 2:
					System.out.println("Vous avez choisi de supprimer un consultant");
					sc1.nextLine();
					
					consService.supprimer(session);
					break;
				case 3:
					System.out.println("Vous avez choisi de consulter la liste des consultants");
					sc1.nextLine();
					consService.consultation(session);
					
					
					/*try {
						// System.out.println("Enter le debut du titre du
						// livre");

						// String nom = sc1.nextLine();

						Connection conn = ConnectionDB.getConnection();
						ResultSet resultContainer = ConsService.getconsultation("Select *  FROM consultant ",
								conn.createStatement());
						while (resultContainer.next()) {
							int id1 = resultContainer.getInt("idconsultant"); // ou
																				// bien
							String nom1 = resultContainer.getString("nom");
							String prenom1 = resultContainer.getString("prenom");

							Date dateNai = resultContainer.getDate("dateNaissance",
									Calendar.getInstance(TimeZone.getTimeZone("UTC")));
							String spe1 = resultContainer.getString("spe");
							int nbHeure = resultContainer.getInt("nbHeureDispo");
							int cyForm = resultContainer.getInt("cycleFormation"); // resultContainer.getInt
							// (2)

							System.out.println(" identifiant:" + id1 + "\tnom: " + nom1 + "\tpr�nom: " + prenom1
									+ "\tdate de naissance: " + dateNai + "\tsp�cialit�: " + spe1
									+ "\tnombre heure dispo: " + nbHeure + "\tcycle de formation: " + cyForm);

							

						}
						ConnectionDB.closeConnection(conn);
					} catch (Exception e) {
						e.printStackTrace();
					}*/
					break;
				}
				break;

			case 2:
				System.out.println("Vous avez choisi le service de gestion des apprenants");

				System.out.println("1- Ajouter un apprenant \n2- Supprimer un apprenant  \n3- Consulter un apprenant");
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

					System.out.println("Veuillez entrer un pr�nom:");
					String prenom = sc1.nextLine();

					System.out.println("Veuillez entrer un diplome:");
					String diplome = sc1.nextLine();

					System.out.println("Veuillez entrer un lien de CV:");
					String cv = sc1.nextLine();

					appService.ajouter(
							"insert into  centreformation.apprenant (nom, prenom ,dateNaissance ,diplome, cv) values ('"
									+ nom + "','" + prenom + "' , '" + sqlDate + "', '" + diplome + "', '" + cv + "')", session);

					break;

				case 2:
					System.out.println("Vous avez choisi de supprimer un apprenant");
					sc1.nextLine();
					System.out.println("Choisir le nom de l'apprenant");
					String nomSelect = sc1.nextLine();

					System.out.println("Choisir le prenom de l'apprenant");
					String prenomSelect = sc1.nextLine();
					consService.supprimer( session);
					break;

				case 3:
					System.out.println("Vous avez choisi de consulter la liste des apprenants");
					sc1.nextLine();
					appService.consultation(session);
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
					System.out.println("Veuillez entrer une date de d�but au format yyyy-mm-dd :");
					String dateDebut = sc1.nextLine();
					Date dNaiss = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
					// String dateToStr=
					// DateFormat.getDateInstance().format(dNaiss);
					// java.sql.Date dateToSql=new java.sql.Date(dNaiss);// date
					// pour sql
					java.sql.Date sqlDate = new java.sql.Date(dNaiss.getTime());

					cyclFormService.ajouter(
							"insert into  centreformation.cycleformation (titre, description ,nbHeureForm ,dateDebut) values ('"
									+ titre + "','" + description + "' , '" + nbHeureForm + "', '" + sqlDate + "')", session);

					break;
				case 2:
					System.out.println("Vous avez choisi de supprimer un Cycle de formation");
					sc1.nextLine();
					System.out.println("Choisir le titre de la formation");
					String titreSel = sc1.nextLine();

					System.out.println("Choisir l'id de la formation");
					int id = sc1.nextInt();
					consService.supprimer( session);
					break;
				case 3:
					System.out.println("Vous avez choisi de consulter les cycles de formation");
					sc1.nextLine();
					cyclFormService.consultation(session);
					

					break;
				}
				break;

			}

			System.out.println("entrer votre choix pour continuer \n1-Continuer \n2-Arret");

			Choix = sc1.nextInt();

		} while (Choix == 1);
		
	}
}

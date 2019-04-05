package com.fr.adaming.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idPersonne;
	private String dateNaissance;
	private String nom;
	private String prenom;

	public Personne(String dateNaissance, String nom, String prenom) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dn) {
		this.dateNaissance = dn;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}

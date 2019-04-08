package com.fr.adaming.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apprenant extends Personne{
//	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
//	@Column(name="id_app")
//	private int id;
	private String diplome; 
	private String cv;

	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apprenant(String dateNaissance, String nom, String prenom) {
		super(dateNaissance, nom, prenom);
		// TODO Auto-generated constructor stub
	}
	public Apprenant(String dateNaissance, String nom, String prenom, String diplome, String cv) {
		super(dateNaissance, nom, prenom);
		this.diplome = diplome;
		this.cv = cv;
	
	}
	public Apprenant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Apprenant [date de naissance=" +getDateNaissance() +
			", pr�nom="+getPrenom()+" ,nom="+getNom()+",diplome=" + diplome + ", cv=" + cv + ", cycleFormation=" +"]";
	}
	
}

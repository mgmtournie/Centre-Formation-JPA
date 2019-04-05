package com.fr.adaming.Entities;

import javax.persistence.Entity;


@Entity
public class Consultant extends Personne {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
//	@Column(name="id_cons")
//	private int id; 
	private String spe;
	private int nbHeureDispo;

	public Consultant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	
	
	public Consultant(String dateNaissance, String nom, String prenom) {
		super(dateNaissance, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	public Consultant(String dateNaissance, String nom, String prenom, String spe, int nbHeureDispo) {
		super(dateNaissance, nom, prenom);
		this.spe = spe;
		this.nbHeureDispo = nbHeureDispo;
	}

	public Consultant(String spe, int nbHeureDispo) {
		super();
		this.spe = spe;
		this.nbHeureDispo = nbHeureDispo;
	}

	public String getSpe() {
		return spe;
	}

	public void setSpe(String spe) {
		this.spe = spe;
	}

	public int getNbHeureDispo() {
		return nbHeureDispo;
	}

	public void setNbHeureDispo(int nbHeureDispo) {
		this.nbHeureDispo = nbHeureDispo;
	}

	@Override
	public String toString() {
		return "Consultant [date de naissance=" + getDateNaissance() + ", pr�nom=" + getPrenom() + " ,nom=" + getNom()
				+ ",spe=" + spe + ", nbHeureDispo=" + nbHeureDispo + "]";
	}

}

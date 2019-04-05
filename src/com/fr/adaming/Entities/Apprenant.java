package com.fr.adaming.Entities;

public class Apprenant extends Personne{
//	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
//	@Column(name="id_app")
//	private int id;
	private String diplome; 
	private String cv;
	private String cycleFormation; 
	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apprenant(String dateNaissance, String nom, String prenom) {
		super(dateNaissance, nom, prenom);
		// TODO Auto-generated constructor stub
	}
	public Apprenant(String dateNaissance, String nom, String prenom, String diplome, String cv, String cycleFormation) {
		super(dateNaissance, nom, prenom);
		this.diplome = diplome;
		this.cv = cv;
		this.cycleFormation = cycleFormation;
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
	public String getCycleFormation() {
		return cycleFormation;
	}
	public void setCycleFormation(String cycleFormation) {
		this.cycleFormation = cycleFormation;
	}
	@Override
	public String toString() {
		return "Apprenant [date de naissance=" +getDateNaissance() +
			", pr�nom="+getPrenom()+" ,nom="+getNom()+",diplome=" + diplome + ", cv=" + cv + ", cycleFormation=" + cycleFormation + "]";
	}
	
}

package com.fr.adaming.Entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CycleFormation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_cf")
	private int id; 
	private String titre;
	private String description;
	private int nbHeureForm;
	private String dateDebut;
	
//	private List<Apprenant> listApp;

	public CycleFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CycleFormation(String titre, String description, int nbHeureForm, String dateDebut,
			List<Apprenant> listApp) {
		super();
		this.titre = titre;
		this.description = description;
		this.nbHeureForm = nbHeureForm;
		this.dateDebut = dateDebut;
//		this.listApp = listApp;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbHeureForm() {
		return nbHeureForm;
	}

	public void setNbHeureForm(int nbHeureForm) {
		this.nbHeureForm = nbHeureForm;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

//	public List<Apprenant> getListApp() {
//		return listApp;
//	}
//
//	public void setListApp(List<Apprenant> listApp) {
//		this.listApp = listApp;
//	}

	@Override
	public String toString() {
		return "CycleFormation [titre=" + titre + ", description=" + description + ", nbHeureForm=" + nbHeureForm
				+ ", dateDebut=" + dateDebut +  "]";
	}

}

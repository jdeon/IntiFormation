package com.inti05.formation.entities;

import java.io.Serializable;
/**
 *  @author Shéhérazade
 *  Nom projet : Inti05
 *  Date : 25/05/2016
 *  Package : com.inti05.formation.entities
 *  Class : Materiel
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Materiel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* Mettre association etudiant */
	private Long idMateriel;
	private String nomMateriel;
	private String etat;
	
////////////////////////////////////////////
////////////Getters and Setters////////////
///////////////////////////////////////////

	public Long getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(Long idMateriel) {
		this.idMateriel = idMateriel;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	/////////////////////////////////////////////
	//////////////////Constructors///////////////
	/////////////////////////////////////////////

	public Materiel(String nomMateriel, String etat) {
		super();
		this.nomMateriel = nomMateriel;
		this.etat = etat;
	}

	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

}

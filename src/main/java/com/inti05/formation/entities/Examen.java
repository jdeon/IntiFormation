package com.inti05.formation.entities;

import java.io.Serializable;

/**
 *  @author Shéhérazade
 *  Nom projet : Inti05
 *  Date : 25/05/2016
 *  Package : com.inti05.formation.entities
 *  Class : Examen
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 
 *  Association :  ManyToOne Etudiant
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Examen implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExamen;
	private String nomExamen;
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	private Double noteExamen;
	
////////////////////////////////////////////
//////////////Associations/////////////////
///////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "id_Etudiant")
	private Etudiant etudiant;

	
////////////////////////////////////////////
////////////Getters and Setters////////////
///////////////////////////////////////////

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public String getNomExamen() {
		return nomExamen;
	}

	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}

	public Date getDateExamen() {
		return dateExamen;
	}

	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}

	public Double getNoteExamen() {
		return noteExamen;
	}

	public void setNoteExamen(Double noteExamen) {
		this.noteExamen = noteExamen;
	}
	/////////////////////////////////////////////
	//////////////////Constructors///////////////
	/////////////////////////////////////////////

	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Examen(String nomExamen, Date dateExamen, Double noteExamen) {
		super();
		this.nomExamen = nomExamen;
		this.dateExamen = dateExamen;
		this.noteExamen = noteExamen;
	}

}

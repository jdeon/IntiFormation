package com.inti05.formation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Etudiant implements Serializable {
	
  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nomEtu;
	private String prenomEtu;

	@Temporal(TemporalType.DATE)
	private Date datedeNaissanceEtu;
	private String telephoneEtu;
	private String mail;
	private String specialitéEtu;

	
	////////////////////////////////////////////
	//////////////Associations/////////////////
	///////////////////////////////////////////
	
	@OneToMany
	@JoinColumn(name = "id_materiel")
	
	private Materiel materiel;

	@ManyToOne
	@JoinColumn(name = "id_Session")
	private Session session;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiant")
	private List<Examen> listeExamen = new ArrayList<Examen>();
	
	
	////////////////////////////////////////////
	////////////Getters and Setters////////////
	///////////////////////////////////////////

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Examen> getListeExamen() {
		return listeExamen;
	}

	public void setListeExamen(List<Examen> listeExamen) {
		this.listeExamen = listeExamen;
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtu() {
		return nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	public String getPrenomEtu() {
		return prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	public Date getDatedeNaissanceEtu() {
		return datedeNaissanceEtu;
	}

	public void setDatedeNaissanceEtu(Date datedeNaissanceEtu) {
		this.datedeNaissanceEtu = datedeNaissanceEtu;
	}

	public String getTelephoneEtu() {
		return telephoneEtu;
	}

	public void setTelephoneEtu(String telephoneEtu) {
		this.telephoneEtu = telephoneEtu;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSpecialitéEtu() {
		return specialitéEtu;
	}

	public void setSpecialitéEtu(String specialitéEtu) {
		this.specialitéEtu = specialitéEtu;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	
	/////////////////////////////////////////////
	//////////////////Constructors///////////////
	/////////////////////////////////////////////
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nomEtu, String prenomEtu, Date datedeNaissanceEtu,
			String telephoneEtu, String mail, String specialitéEtu) {
		super();
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.datedeNaissanceEtu = datedeNaissanceEtu;
		this.telephoneEtu = telephoneEtu;
		this.mail = mail;
		this.specialitéEtu = specialitéEtu;

	}

}

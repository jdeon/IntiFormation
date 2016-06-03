package com.inti05.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.inti05.formation.entities.Materiel;
import com.inti05.formation.metier.InterMaterielMetier;

@Controller
@ManagedBean(name="materielBean")
@RequestScoped
public class MaterielBean implements Serializable {

	Logger log = Logger.getLogger("MaterielBean");

	@Autowired
	private InterMaterielMetier metierMateriel;

	private Materiel m = new Materiel();
	private List<Materiel> listm = new ArrayList<Materiel>();
	private Long idMat;
	private String updtNomMateriel;
	private String updtEtatMateriel;
	private String nomMateriel;
	private String etat;
	private Materiel getMat;

	public Materiel getGetMat() {
		return getMat;
	}

	public void setGetMat(Materiel getMat) {
		this.getMat = getMat;
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

	public String getUpdtNomMateriel() {
		return updtNomMateriel;
	}

	public void setUpdtNomMateriel(String updtNomMateriel) {
		this.updtNomMateriel = updtNomMateriel;
	}

	public String getUpdtEtatMateriel() {
		return updtEtatMateriel;
	}

	public void setUpdtEtatMateriel(String updtEtatMateriel) {
		this.updtEtatMateriel = updtEtatMateriel;
	}

	public InterMaterielMetier getMetierMateriel() {
		return metierMateriel;
	}

	public void setMetierMateriel(InterMaterielMetier metierMateriel) {
		this.metierMateriel = metierMateriel;
	}

	public Materiel getM() {
		return m;
	}

	public void setM(Materiel m) {
		this.m = m;
	}

	public List<Materiel> getListm() {
		return listm;
	}

	public void setListm(List<Materiel> listm) {
		this.listm = listm;
	}

	public Long getIdMat() {
		return idMat;
	}

	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}

	public MaterielBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************* Méthodes *******************/

	public Materiel ajouterM() {
		metierMateriel.addM(m);
		return m;

	}

	public void supprimerM() {
		metierMateriel.supM(idMat);

	}

	public Materiel modifierM() {
		Materiel m1 = metierMateriel.getById(idMat);
		if (updtEtatMateriel.length() > 0) {
			m1.setEtat(etat);
		}
		if (updtNomMateriel.length() > 0) {
			m1.setNomMateriel(nomMateriel);
		}

		metierMateriel.modM(m1);

		log.info("le materiel" + m1.getNomMateriel() + "a bien été supprimer");
		return m1;

	}

	public List<Materiel> getList() {
		return metierMateriel.getList();

	}

	public void getById() {
		getMat =  metierMateriel.getById(idMat);

	}

}

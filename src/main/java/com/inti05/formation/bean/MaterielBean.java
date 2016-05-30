package com.inti05.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.inti05.formation.entities.Materiel;
import com.inti05.formation.metier.InterMaterielMetier;

@Controller
@Component("materielBean")
@RequestScoped
public class MaterielBean implements Serializable {

	@Autowired
	private InterMaterielMetier metierMateriel;

	private Materiel m = new Materiel();
	private List<Materiel> listm = new ArrayList<Materiel>();
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Materiel supprimerM() {
		return metierMateriel.supM(id);

	}

	public Materiel modifierM() {
		return metierMateriel.modM(m);

	}

	public List<Materiel> getList() {
		return metierMateriel.getList();

	}

	public Materiel getById() {
		return metierMateriel.getById(id);

	}

}

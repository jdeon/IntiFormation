package com.inti05.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.inti05.formation.entities.Examen;
import com.inti05.formation.metier.InterExamMetier;

@Controller
@Component("examBean")
@RequestScoped
public class ExamenBean implements Serializable {

	@Autowired
	private InterExamMetier metierExamen;

	private Examen ex = new Examen();
	private List<Examen> listeex = new ArrayList<Examen>();
	private Long id;

	public InterExamMetier getMetierExamen() {
		return metierExamen;
	}

	public void setMetierExamen(InterExamMetier metierExamen) {
		this.metierExamen = metierExamen;
	}

	public Examen getEx() {
		return ex;
	}

	public void setEx(Examen ex) {
		this.ex = ex;
	}

	public List<Examen> getListeex() {
		return listeex;
	}

	public void setListeex(List<Examen> listeex) {
		this.listeex = listeex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamenBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*********************** Méthodes **********************/

	public Examen addEx() {
		metierExamen.addExamen(ex);
		return ex;
	}

	public List<Examen> listeExamen() {

		listeex = metierExamen.getListExam();
		return listeex;

	}

	public Examen deleteExam() {
		return metierExamen.supExam(id);

	}

	public Examen modifExam() {
		return metierExamen.modifExam(ex);
	}

	public Examen getbyId() {
		return metierExamen.getbyId(id);
	}

}

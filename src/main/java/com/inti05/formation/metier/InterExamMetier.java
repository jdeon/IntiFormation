package com.inti05.formation.metier;

import java.util.List;

import com.inti05.formation.entities.Examen;

public interface InterExamMetier {
	public Examen addExamen(Examen ex);
	public List<Examen> getListExam();
	public Examen supExam(Long id);
	public Examen modifExam(Long id);
	public Examen getbyId(Long id);

}

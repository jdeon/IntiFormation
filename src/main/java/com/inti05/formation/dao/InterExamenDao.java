package com.inti05.formation.dao;

import java.util.List;

import com.inti05.formation.entities.Examen;

public interface InterExamenDao {
	
	public Examen addExamen(Examen ex);
	public List<Examen> getListExam();
	public Examen supExam(Long id);
	public Examen modifExam(Examen ex);
	public Examen getbyId(Long id);
	
	


}

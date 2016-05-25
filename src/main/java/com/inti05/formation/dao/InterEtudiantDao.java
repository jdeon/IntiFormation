package com.inti05.formation.dao;

import java.util.List;

import com.inti05.formation.entities.Etudiant;

public interface InterEtudiantDao {
	public Etudiant addEtudiant(Etudiant e);
	public List<Etudiant> listeEtudiant();
	public Etudiant supEtudiant(Long id);
	public Etudiant modifEtudiant(Long id);
	public List<Etudiant> getlistParMc(String mc);
	public List<Etudiant> getListNomExacte(String nom);
	public Etudiant getById(Long id);
	
	

}

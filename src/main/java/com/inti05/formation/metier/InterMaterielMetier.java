package com.inti05.formation.metier;

import java.util.List;

import com.inti05.formation.entities.Materiel;

public interface InterMaterielMetier {
	public Materiel addM(Materiel m);
	public Materiel supM(Long id);
	public Materiel modM(Long id);
	public List<Materiel> getList();
	public Materiel getById(Long id);
	

}

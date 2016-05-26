package com.inti05.formation.dao;

import java.util.List;

import com.inti05.formation.entities.Materiel;

public interface InterMaterielDao {
	
	public Materiel addM(Materiel m);
	public Materiel supM(Long id);
	public Materiel modM(Materiel m);
	public List<Materiel> getList();
	public Materiel getById(Long id);
	

}

package com.inti05.formation.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti05.formation.entities.Materiel;
import com.inti05.formation.metier.InterMaterielMetier;

@WebService
public class MaterielSoap {
	
	
	@Autowired
	private InterMaterielMetier metier;
	
	@WebMethod
	public Materiel saveMateriel(Materiel m){
		
		return metier.addM(m);
		
	}
	@WebMethod
	public Materiel getByID(@WebParam Long idM){
		return metier.getById(idM);
	}
	
	
	
	



}

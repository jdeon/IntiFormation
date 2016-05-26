package com.inti05.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.inti05.formation.entities.Examen;

public class ExamenDaoImpl implements InterExamenDao {

	Logger log = Logger.getLogger("ExamenDaoImpl");

	@PersistenceContext
	private EntityManager em;

	@Override
	public Examen addExamen(Examen ex) {
		em.persist(ex);
		log.info("l'examen" + ex.getNomExamen() + " a bien été ajouter");
		return ex;
	}

	@Override
	public List<Examen> getListExam() {
		Query query = em.createQuery("from Examen ex");
		log.info("Voici le nombre d'examens " + query.getResultList().size());

		return query.getResultList();
	}

	@Override
	public Examen supExam(Long id) {
		Examen ex = em.find(Examen.class, id);
		em.remove(ex);
		log.info("L'examen " + ex.getIdExamen() + "a bien été ajouter");
		return ex;
	}

	@Override
	public Examen modifExam(Examen ex) {
	
		em.merge(ex);
		log.info("L'examen " + ex.getIdExamen() + "a bien été modifier");

		return ex;
	}

	@Override
	public Examen getbyId(Long id) {
		Examen ex = em.find(Examen.class, id);
		log.info("L'examen " + ex.getIdExamen() + "a bien été trouver");

		return ex;
	}

}

package com.inti05.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.inti05.formation.entities.Materiel;

public class MaterielDaoImpl implements InterMaterielDao {

	Logger log = Logger.getLogger("MaterielDaoImpl");
	@PersistenceContext
	private EntityManager em;

	@Override
	public Materiel addM(Materiel m) {
		em.persist(m);
		log.info("Le materiel " + m.getIdMateriel() + "a bien été ajouter ");

		return m;
	}

	@Override
	public Materiel supM(Long id) {
		Materiel m = em.find(Materiel.class, id);
		em.remove(m);
		log.info("le materiel" + m.getIdMateriel() + "a bien été supprimer");
		return m;
	}

	@Override
	public Materiel modM(Long id) {
		Materiel m = em.find(Materiel.class, id);
		em.merge(m);
		log.info("le materiel" + m.getIdMateriel() + "a bien été modifier");
		return m;
	}

	@Override
	public List<Materiel> getList() {
		Query query = em.createQuery("from Materiel m");
		log.info("Le nombre de materiel est " + query.getResultList().size());

		return query.getResultList();
	}

	@Override
	public Materiel getById(Long id) {
		Materiel m = em.find(Materiel.class, id);
		log.info("le materiel" + m.getIdMateriel()
				+ "a bien été trouver par son id");
		return m;
	}

}

package com.inti05.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.inti05.formation.entities.Etudiant;

public class EtudiantDaoImpl implements InterEtudiantDao {

	Logger log = Logger.getLogger("EtudiantDaoImpl");
	@PersistenceContext
	private EntityManager em;

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		em.persist(e);
		log.info("l'�tudiant " + e.getIdEtudiant() + "� bien �t� ajouter ");
		return e;
	}

	@Override
	public List<Etudiant> listeEtudiant() {
		Query query = em.createQuery("from Etudiant e");
		log.info("Le nombre d'�tudiant est " + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Etudiant supEtudiant(Long id) {
		Etudiant e = em.find(Etudiant.class, id);
		em.remove(e);
		log.info("l'�tudiant " + e.getNomEtu() + "a bien �t� supprim�");
		return e;
	}


	@Override
	public List<Etudiant> getlistParMc(String mc) {
		Query query = em.createQuery("from Etudiant e where e.nomEtu  like :x  or e.prenomEtu like :x");
		query.setParameter("x", "%" + mc + "%");
		log.info("la liste des �tudiant par mots cl�s contient"
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<Etudiant> getListNomExacte(String nom) {
		Query query = em.createQuery("from Etudiant e where e.nomEtu like :x");
		query.setParameter("x", nom);
		log.info("la liste par nom exacte contient "
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Etudiant getById(Long id) {
		Etudiant e = em.find(Etudiant.class, id);
		log.info("L'�tudiant est bien renvoy�" + e.getIdEtudiant());
		return e;
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e) {
		em.merge(e);
		log.info("l'�tudiant " + e.getNomEtu() + "a bien �t� modifier");
		return e;
	}

}

package com.inti05.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.inti05.formation.entities.Etudiant;
import com.inti05.formation.entities.Examen;
import com.inti05.formation.entities.Materiel;

public class EtudiantDaoImpl implements InterEtudiantDao {

	Logger log = Logger.getLogger("EtudiantDaoImpl");
	@PersistenceContext
	private EntityManager em;

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		em.persist(e);
		log.info("l'étudiant " + e.getIdEtudiant() + "à bien été ajouter ");
		return e;
	}

	@Override
	public List<Etudiant> listeEtudiant() {
		Query query = em.createQuery("from Etudiant e");
		log.info("Le nombre d'étudiant est " + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Etudiant supEtudiant(Long id) {
		Etudiant e = em.find(Etudiant.class, id);
		em.remove(e);
		log.info("l'étudiant " + e.getNomEtu() + "a bien été supprimé");
		return e;
	}


	@Override
	public List<Etudiant> getlistParMc(String mc) {
		Query query = em.createQuery("from Etudiant e where e.nomEtu  like :x  or e.prenomEtu like :x");
		query.setParameter("x", "%" + mc + "%");
		log.info("la liste des étudiant par mots clés contient"
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Etudiant getListNomExacte(String nom,String prenom) {
		Query query = em.createQuery("from Etudiant e where e.nomEtu like :x and e.prenomEtu like :y");
		query.setParameter("x", nom);
		query.setParameter("y", prenom);
		log.info("la liste par nom exacte contient "
				+ query.getResultList().size());
		Etudiant e = (Etudiant) query.getResultList().get(0);
		return e;
	}

	@Override
	public Etudiant getById(Long id) {
		Etudiant e = em.find(Etudiant.class, id);
		log.info("L'étudiant est bien renvoyé" + e.getIdEtudiant());
		return e;
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e) {
		em.merge(e);
		log.info("l'étudiant " + e.getNomEtu() + "a bien été modifier");
		return e;
	}

	@Override
	public Etudiant addExamToEtudiant(Long idExam, Long idEtudiant) {
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		Examen ex= em.find(Examen.class, idExam);
		e.getListeExamen().add(ex);
		ex.setEtudiant(e);
		em.merge(e);
		em.merge(ex);
		return e;
	}

	@Override
	public Etudiant supExamToEtudiant(Long idExam, Long idEtudiant) {
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		Examen ex= em.find(Examen.class, idExam);
		e.getListeExamen().remove(ex);
		ex.setEtudiant(null);
		em.merge(e);
		em.merge(ex);
		return e;
	}

	@Override
	public Etudiant addMaterToEtudiant(Long idMateriel, Long idEtudiant) {
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		Materiel m = em.find(Materiel.class, idMateriel);
		e.getListmateriel().add(m);
		em.merge(e);
		return e;

	}

	@Override
	public Etudiant supMaterToEtudiant(Long idMateriel, Long idEtudiant) {
		
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		Materiel m = em.find(Materiel.class, idMateriel);
		e.getListmateriel().remove(m);
		em.merge(e);
		return e;
	}
	
	@Override
	public List<Etudiant> listEtudiantSansFormation() {
		Query req = em.createQuery("SELECT e FROM Etudiant e WHERE e.session IS NULL");
		return req.getResultList();
	}

}

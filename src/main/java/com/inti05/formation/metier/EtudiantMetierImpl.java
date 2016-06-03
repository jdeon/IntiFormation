package com.inti05.formation.metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.inti05.formation.dao.InterEtudiantDao;
import com.inti05.formation.entities.Etudiant;

@Transactional
public class EtudiantMetierImpl implements InterEtudiantMetier {
	
	Logger log = Logger.getLogger("EtudiantMetierImpl");
	private InterEtudiantDao daoEt;
	



	public void setDaoEt(InterEtudiantDao daoEt) {
		this.daoEt = daoEt;
		log.info("dao injected");
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return daoEt.addEtudiant(e);
	}

	@Override
	public List<Etudiant> listeEtudiant() {
		// TODO Auto-generated method stub
		return daoEt.listeEtudiant();
	}

	@Override
	public Etudiant supEtudiant(Long id) {
		// TODO Auto-generated method stub
		return daoEt.supEtudiant(id);
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return daoEt.modifEtudiant(e);
	}

	@Override
	public List<Etudiant> getlistParMc(String mc) {
		// TODO Auto-generated method stub
		return daoEt.getlistParMc(mc);
	}

	@Override
	public  Etudiant getListNomExacte(String nom,String prenom) {
		// TODO Auto-generated method stub
		return daoEt.getListNomExacte(nom, prenom);
	}

	@Override
	public Etudiant getById(Long id) {
		// TODO Auto-generated method stub
		return daoEt.getById(id);
	}

	@Override
	public Etudiant addExamToEtudiant(Long idExam, Long idEtudiant) {
		
		return daoEt.addExamToEtudiant(idExam, idEtudiant);
	}

	@Override
	public Etudiant supExamToEtudiant(Long idExam, Long idEtudiant) {
		// TODO Auto-generated method stub
		return daoEt.supExamToEtudiant(idExam, idEtudiant);
	}

	@Override
	public Etudiant addMaterToEtudiant(Long idMateriel, Long idEtudiant) {
		// TODO Auto-generated method stub
		return daoEt.addMaterToEtudiant(idMateriel, idEtudiant);
	}

	@Override
	public Etudiant supMaterToEtudiant(Long idMateriel, Long idEtudiant) {
		// TODO Auto-generated method stub
		return daoEt.supMaterToEtudiant(idMateriel, idEtudiant);
	}
	
	@Override
	public List<Etudiant> listEtudiantSansFormation() {
		// TODO Auto-generated method stub
		return daoEt.listEtudiantSansFormation();
	}

}

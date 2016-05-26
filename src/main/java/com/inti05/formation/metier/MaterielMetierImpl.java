package com.inti05.formation.metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.inti05.formation.dao.InterMaterielDao;
import com.inti05.formation.entities.Materiel;

@Transactional
public class MaterielMetierImpl implements InterMaterielMetier {
	
	Logger log = Logger.getLogger("MaterielMetierImpl");
	private InterMaterielDao daoM;
	

	public void setDaoM(InterMaterielDao daoM) {
		this.daoM = daoM;
		log.info("dao injected");
	}

	@Override
	public Materiel addM(Materiel m) {
		// TODO Auto-generated method stub
		return daoM.addM(m);
	}

	@Override
	public Materiel supM(Long id) {
		// TODO Auto-generated method stub
		return daoM.supM(id);
	}

	@Override
	public Materiel modM(Materiel m) {
		// TODO Auto-generated method stub
		return daoM.modM(m);
	}

	@Override
	public List<Materiel> getList() {
		// TODO Auto-generated method stub
		return daoM.getList();
	}

	@Override
	public Materiel getById(Long id) {
		// TODO Auto-generated method stub
		return daoM.getById(id);
	}

}

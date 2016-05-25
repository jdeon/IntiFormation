package com.inti05.formation.metier;

import java.time.DayOfWeek;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.Days;
import org.springframework.transaction.annotation.Transactional;

import com.inti05.formation.dao.InterExamenDao;
import com.inti05.formation.entities.Examen;

@Transactional
public class ExamenMetierImpl implements InterExamMetier {
	
	Logger log= Logger.getLogger("ExamenMetierImpl");
	private InterExamenDao daoEx;

	public void setDaoEx(InterExamenDao daoEx) {
		this.daoEx = daoEx;
		log.info("dao injected");
	}

	@Override
	public Examen addExamen(Examen ex) {
		// TODO Auto-generated method stub
		return daoEx.addExamen(ex);
	}

	@Override
	public List<Examen> getListExam() {
		// TODO Auto-generated method stub
		return daoEx.getListExam();
	}

	@Override
	public Examen supExam(Long id) {
		// TODO Auto-generated method stub
		return daoEx.supExam(id);
	}

	@Override
	public Examen modifExam(Long id) {
		// TODO Auto-generated method stub
		return daoEx.modifExam(id);
	}

	@Override
	public Examen getbyId(Long id) {
		// TODO Auto-generated method stub
		return daoEx.getbyId(id);
	}
	

}

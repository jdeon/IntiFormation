package com.inti05.formation.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.ExactComparisonCriteria;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inti05.formation.entities.Examen;
import com.inti05.formation.metier.InterExamMetier;

public class TestExamen {
	
	private static InterExamMetier metier;
	private static ClassPathXmlApplicationContext context;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterExamMetier) context.getBean("metierExamen");
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	/*@Test
	public void testAddExamen() {
		Examen ex= metier.addExamen(new Examen("Spring", new Date(), 10d));
		Examen ex1 = metier.addExamen(new Examen("Angular", new Date(), 20d));
		Examen ex2=metier.addExamen(new Examen("JSF", new Date(), 15d));
		
		
	}

	@Test
	public void testGetListExam() {
		List<Examen> tab = metier.getListExam();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testSupExam() {
		Long id = 1L;
		Examen ex= metier.supExam(id);
		assertEquals(id, ex.getIdExamen());
	}

		@Test
	public void testModifExam() {
		Examen ex= metier.getbyId(2L);
		ex.setNomExamen("ERREUR");
		metier.modifExam(ex);
		assertTrue(ex.getNomExamen()=="ERREUR");
	}*/
		
	@Test
	public void testGetbyId() {
	  Long id = 2L;
	  Examen ex= metier.getbyId(id);
		assertEquals(id, ex.getIdExamen());

	}

}

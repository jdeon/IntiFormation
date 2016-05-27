package com.inti05.formation.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inti05.formation.entities.Etudiant;
import com.inti05.formation.entities.Examen;
import com.inti05.formation.metier.InterEtudiantMetier;

public class TestEtudiant {

	private static InterEtudiantMetier metier;
	private static ClassPathXmlApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterEtudiantMetier) context.getBean("metierEtudiant");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	/*	@Test
	public void testAddEtudiant() {
		Etudiant e= metier.addEtudiant(new Etudiant("Duroc", "Sébastien", new Date(),"01 03 30 25 16", "duroc@hotmail.fr", "Maths"));
		Etudiant e1= metier.addEtudiant(new Etudiant("LeNouveau", "Philippe", new Date(),"01 52 36 58", "philippe@hotmail.fr", "INFO"));
		Etudiant e2= metier.addEtudiant(new Etudiant("Legrand", "Henry", new Date(),"01 54 68 99 78", "henry@hotmail.fr", "Mecanique"));
		assertNotNull(e.getIdEtudiant());
		assertNotNull(e1.getIdEtudiant());
		assertNotNull(e2.getIdEtudiant());
	}

	@Test
	public void testListeEtudiant() {
		List<Etudiant> tab= metier.listeEtudiant();
		assertTrue(tab.size()>0);
	}*/

	/*	@Test
	public void testSupEtudiant() {
			Long id = 1L;
		Etudiant e= metier.supEtudiant(id);
	
		assertEquals(id, e.getIdEtudiant());
		
	}

	@Test
	public void testModifEtudiant() {
		Etudiant e = metier.getById(2L);
		e.setMail("nouveau Mail");
		metier.modifEtudiant(e);
		assertTrue(e.getMail()=="nouveau Mail");
	}*/
		

	/*
	@Test
	public void testGetlistParMc() {
	
		List<Etudiant> ter = metier.getlistParMc("d");
		assertTrue(ter.size()>0);
	}*/

	/*			@Test
	public void testGetListNomExacte() {
				List<Etudiant> list = metier.getListNomExacte("Duroc");
				assertTrue(list.size()>0);
}

	@Test
	public void testGetById() {
		Long id= 2L;
		Etudiant e = metier.getById(id);
		assertEquals(id, e.getIdEtudiant());
		
	}*/
	
	@Test
	public void addExtoEtu(){
		Long idEtu=4L;
		Etudiant e1 = metier.getById(idEtu);
		List<Examen> exEtu = e1.getListeExamen();
		
		Long idEx=2L;
		Etudiant e=metier.addExamToEtudiant(idEx, idEtu);
		List<Examen> exEtu2 = e1.getListeExamen();
		assertTrue(exEtu.size()<exEtu2.size());
		
		
	}

}

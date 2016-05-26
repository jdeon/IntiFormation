package com.inti05.formation.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inti05.formation.entities.Materiel;
import com.inti05.formation.metier.InterMaterielMetier;

public class TestMateriel {
	
	private static InterMaterielMetier metier;
	private static ClassPathXmlApplicationContext context;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterMaterielMetier) context.getBean("metierMateriel");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	/*
	@Test
	public void testAddM() {
		Materiel m =metier.addM(new Materiel("ordinateur", "fonctionne"));
		Materiel m1 = metier.addM(new Materiel("Souris", "BOn état"));
	}*/

	/*@Test
	public void testSupM() {
		Long id=1L;
		Materiel m =metier.supM(id);
		assertEquals(id, m.getIdMateriel());
	}*/

	/*@Test
	public void testModM() {
		Materiel m = metier.getById(2L);
		m.setEtat("mal");
		metier.modM(m);
		assertTrue(m.getEtat()=="mal");
	}*/

@Test
	public void testGetById() {
		Long id = 2L;
		Materiel m = metier.getById(id);
		assertEquals(id, m.getIdMateriel());
	}
}

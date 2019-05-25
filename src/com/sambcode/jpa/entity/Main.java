package com.sambcode.jpa.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		insertar();
	}

	public static void insertar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplejpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			Tperson tPerson = new Tperson();

			tPerson.setFirsName("It is all");
			tPerson.setIdentificationDocment("848224595");
			tPerson.setEmail("its@gmail.com");
			tPerson.setBirthdate("2000/11/10");
			tPerson.setState(true);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String registrationDate = sdf.format(new Date());
			tPerson.setRegistrationDate(registrationDate);

			et.begin();
			em.persist(tPerson);
			et.commit();

			System.out.println("Record made");

		} catch (Exception e) {

			et.rollback();

			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

}

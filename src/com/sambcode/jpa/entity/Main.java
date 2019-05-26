package com.sambcode.jpa.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		// insert();
		// edit();
		// delete();
		// readEverything();
		readByidentityDocument("848224595");
	}

	public static void insert() {
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

	public static void edit() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplejpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			int idPerson = 7; // Registry number
			Tperson tPerson = em.find(Tperson.class, idPerson);

			tPerson.setIdentificationDocment("77777777777777");
			tPerson.setEmail("she@outlook.com");

			et.begin();
			em.merge(tPerson);
			et.commit();

			System.out.println("Editing done correctly");

		} catch (Exception e) {

			et.rollback();

			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public static void delete() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplejpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			int idPerson = 6; // Registry number
			Tperson tPerson = em.find(Tperson.class, idPerson);

			et.begin();
			em.remove(tPerson);
			et.commit();

			System.out.println("Record removed");

		} catch (Exception e) {

			et.rollback();

			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public static void readEverything() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplejpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			TypedQuery<Tperson> query = em.createNamedQuery("Tperson.findAll", Tperson.class);
			List<Tperson> listTperson = query.getResultList();
			et.commit();

			for (Tperson item : listTperson) {
				System.out.println(item.getFirsName() + "......" + item.getEmail());
			}

		} catch (Exception e) {

			et.rollback();

			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public static void readByidentityDocument(String identityDocumentValue) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplejpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			TypedQuery<Tperson> query = em.createNamedQuery("Tperson.findByDocumentIdentification", Tperson.class);
			query.setParameter("parameteridentificationDocment", identityDocumentValue);
			List<Tperson> listTperson = query.getResultList();
			et.commit();

			for (Tperson item : listTperson) {
				System.out.println(
						item.getFirsName() + "......" + item.getEmail() + "......" + item.getIdentificationDocment());
			}

		} catch (Exception e) {

			et.rollback();

			System.out.println("Error " + e.getMessage());
		} finally {
			em.close();
		}
	}

}

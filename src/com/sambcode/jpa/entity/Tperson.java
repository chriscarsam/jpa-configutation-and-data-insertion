package com.sambcode.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tperson database table.
 * 
 */
@Entity
@Table(name="tperson")
@NamedQuery(name="Tperson.findAll", query="SELECT t FROM Tperson t")
public class Tperson implements Serializable {
	private static final long serialVersionUID = 1L;

	private String birthdate;

	private String email;

	private String firsName;

	private String identificationDocment;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPerson;

	private String registrationDate;

	private boolean state;

	public Tperson() {
	}

	public String getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirsName() {
		return this.firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getIdentificationDocment() {
		return this.identificationDocment;
	}

	public void setIdentificationDocment(String identificationDocment) {
		this.identificationDocment = identificationDocment;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
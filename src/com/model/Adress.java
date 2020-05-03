package com.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Adress {

	@Temporal(TemporalType.DATE)
	private Date personelComingDate;
	
	@Lob
	private String personelAdress;

	public Date getPersonelComingDate() {
		return personelComingDate;
	}

	public void setPersonelComingDate(Date personelComingDate) {
		this.personelComingDate = personelComingDate;
	}

	public String getPersonelAdress() {
		return personelAdress;
	}

	public void setPersonelAdress(String personelAdress) {
		this.personelAdress = personelAdress;
	}
	
	
}

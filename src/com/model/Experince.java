package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Experincee")
public class Experince extends Profession  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String domain;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	

}

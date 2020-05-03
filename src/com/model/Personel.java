package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@SecondaryTable(name = "PersonelDetail")
@SecondaryTable(name = "PersonelDetail2") 
public class Personel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int personelId;
	private String personelName;
	private String personelSurname;
	
	@Embedded
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "personel_adresslist" ,
	joinColumns = @JoinColumn( name = "personel_personelId"))
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, 
	              generator = "increment-gen", 
	              type = @Type(type = "long"))
	private Collection<Adress> adressList = new ArrayList<Adress>();
	
	@OneToOne(fetch = FetchType.LAZY , cascade  = CascadeType.PERSIST)
	@JoinColumn(name = "professionID")
	private Profession profession ;
	
	/*@Temporal(TemporalType.DATE)
	@Column(table = "PersonelDetail")
	private Date personelComingDate;
	
	@Lob
	@Column(table = "PersonelDetail")
	private String personelAdress;*/
	
	
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public int getPersonelId() {
		return personelId;
	}
	public Collection<Adress> getAdressList() {
		return adressList;
	}
	public void setAdressList(Collection<Adress> adressList) {
		this.adressList = adressList;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public String getPersonelName() {
		return personelName;
	}
	public void setPersonelName(String personelName) {
		this.personelName = personelName;
	}
	public String getPersonelSurname() {
		return personelSurname;
	}
	public void setPersonelSurname(String personelSurname) {
		this.personelSurname = personelSurname;
	}
	/*public Date getPersonelComingDate() {
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
	}*/
	
	
	
}

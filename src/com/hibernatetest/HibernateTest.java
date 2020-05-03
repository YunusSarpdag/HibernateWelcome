package com.hibernatetest;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Adress;
import com.model.Experince;
import com.model.Personel;
import com.model.Profession;

public class HibernateTest {

	public static void main(String[] args) {
		Personel personel = new Personel();
		// personel.setPersonelId(12);
		personel.setPersonelName("Yunus");
		personel.setPersonelSurname("Kartal");

		Adress evAdress = new Adress();
		evAdress.setPersonelAdress("Istanbul");
		evAdress.setPersonelComingDate(new Date());
		personel.getAdressList().add(evAdress);
		////////////
		
		
		Profession profession = new Profession();
		profession.setProfessioName("Computer Engineer");
		
		Profession profession2 = new Profession();
		profession2.setProfessioName("Docktor");
		
		personel.setProfession(profession);
		
		Experince experince = new Experince();
		experince.setDomain("Computer Since");
		experince.setProfessioName("Computer Engineer");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Adress evAdress2 = new Adress();
		evAdress2.setPersonelAdress("Antlya");
		evAdress2.setPersonelComingDate(new Date());
		personel.getAdressList().add(evAdress2);
		////////////

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save(personel);
		//session.save(profession);
		session.persist(personel);
		session.save(profession2);
		session.save(experince);
		session.getTransaction().commit();
		session.close();

		personel = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1);
		System.out.println(personel.getPersonelName());
		System.out.println(personel.getProfession().getProfessioName());
		personel.setPersonelName("Fýrat");
		session.update(personel); // bu satýr olmasa bile update yapardý
		session.getTransaction().commit();
		
		/*session.beginTransaction();
	    session.delete(personel);
		session.getTransaction().commit();*/
		
		session.close();
	}

   
}

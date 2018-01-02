package com.pratik.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.Country;

import com.pratik.domain.State;

import com.pratik.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	public void saveDataUsingCountry() {
		Session ses=null;
		Country country=null;
		State state1=null,state2=null;
		Set<State> childs=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		 country=new Country();
		 country.setName("India");
		 country.setCapital("New Delhi");
		 country.setLanguage("Hindi");
		 
		 state1=new State();
		 state1.setCode("UP");
		 state1.setName("UttarPrdesh");
		 state1.setCapital("luknow");
		 
		 state2=new State();
		 state2.setCode("KR");
		 state2.setName("Kerala");
		 state2.setCapital("Tivendram");
		 //set chils to parent
		 childs=new HashSet<State>();
		 childs.add(state1); childs.add(state2);
		 country.setStates(childs);
		 //set parent to childs
		 state1.setCountry(country);
		 state2.setCountry(country);
		 //save objs (parent to child)
		 try{
			 tx=ses.beginTransaction();
			   ses.save(country);
			  tx.commit();
			  System.out.println("Objects are saved....");
		  }//try
		 catch(Exception e){
			 tx.rollback();
		 }//catch
	}//method

	public void saveDataUsingState() {
		Session ses=null;
		Country country=null;
		State state1=null,state2=null;
		Set<State> childs=null;
		Transaction tx=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		 country=new Country();
		 country.setName("pakistan");
		 country.setCapital("islamabad");
		 country.setLanguage("urdu");
		 
		 state1=new State();
		 state1.setCode("PN");
		 state1.setName("punjab");
		 state1.setCapital("lahore");
		 
		 state2=new State();
		 state2.setCode("BL");
		 state2.setName("Beluchistan");
		 state2.setCapital("ravalpindi");
		 //set chils to parent
		 childs=new HashSet<State>();
		 childs.add(state1); childs.add(state2);
		 country.setStates(childs);
		 //set parent to childs
		 state1.setCountry(country);
		 state2.setCountry(country);
		 //save objs ( child to parent)
		 try{
			 tx=ses.beginTransaction();
			    ses.save(state1);
			    ses.save(state2);
			  tx.commit();
			  System.out.println("Objects are saved....");
		  }//try
		 catch(Exception e){
			 tx.rollback();
		 }//catch

	}//method
	
	@Override
	public void loadDataUsingCountry() {
	Session ses=null;
		Query query=null;
			List<Country> list=null;
				Set<State> childs=null;
	
	//get Session
	ses=HibernateUtil.getSession();
	//create Query obj
	query=ses.createQuery("from Country");
	//execute Query
	list=query.list();
	//process the Results
	for(Country user:list){
		System.out.println("parent---->"+user);
		//get all childs of each parent
		childs=user.getStates();
		//System.out.println(childs.size());
		for(State ph:childs){
			System.out.println("child--->"+ph);
		}//for
	
		}//for
}//method
}//class

package com.pratik.test;

import com.pratik.dao.OneToManyDAO;
import com.pratik.dao.OneToManyDAOFactory;
import com.pratik.utility.HibernateUtil;

public class OTM_BI_Test_LoadData {
	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
	
		dao.loadDataUsingCountry();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

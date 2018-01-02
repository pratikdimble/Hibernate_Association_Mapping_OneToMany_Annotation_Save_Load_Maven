package com.pratik.test;

import com.pratik.dao.OneToManyDAO;
import com.pratik.dao.OneToManyDAOFactory;
import com.pratik.utility.HibernateUtil;

public class OTM_BI_Test_SaveData {
	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=null;
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		dao.saveDataUsingCountry();
		//dao.saveDataUsingState();

		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

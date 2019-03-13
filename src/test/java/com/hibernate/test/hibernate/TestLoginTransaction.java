package com.hibernate.test.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.hibernate.dto.Transactions;
import com.hibernate.test.hibernate.dto.Log;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestLoginTransaction extends TestCase {

	SessionFactory factory = null;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestLoginTransaction(String testName) {
		super(testName);
		factory = new Configuration().configure().buildSessionFactory();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestLoginTransaction.class);
	}

	public void testAddTxns() {
		Transactions txn = new Transactions();
		txn.setUserName("aditya");
		txn.getLogs().add(new Log(new Date(), "login"));
		txn.getLogs().add(new Log(new Date(), "add data to cart"));
		txn.getLogs().add(new Log(new Date(), "updated profile"));
		txn.getLogs().add(new Log(new Date(), "deleted cart item"));
		
		Session session = null;
    	try {
    		session = factory.openSession();
    		session.beginTransaction();
        	session.save(txn);
        	session.getTransaction().commit();
    	} catch (Exception e) {
    		System.out.println("error: " + e.getMessage());
    		session.getTransaction().rollback();
    		assertFalse(e.getMessage(), true);
    	} finally {
    		session.close();
    	}
        assertTrue( true );
	}

}

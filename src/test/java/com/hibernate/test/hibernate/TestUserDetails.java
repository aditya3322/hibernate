package com.hibernate.test.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.hibernate.dto.Address;
import com.hibernate.test.hibernate.dto.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestUserDetails extends TestCase
{
	SessionFactory factory = null;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestUserDetails( String testName )
    {
        super( testName );
        factory = new Configuration().configure().buildSessionFactory();;
       
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestUserDetails.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testUserInsert()
    {
    	User user = new User();
    	user.setUserName("Ankit Awasthi");
    	user.setJoinedDate(new Date());
    	user.setHomeAddress(new Address("Sarita Vihar", "Ghaziabad", "UP", "201009"));
    	user.setOfficeAddress(new Address("sector 123", "Noida", "UP", "201301"));
    	user.setDescription("Father");
    	Session session = null;
    	try {
    		session = factory.openSession();
    		session.beginTransaction();
        	session.save(user);
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
    
    public void testGetUser()
    {
    	Session session = null;
    	try {
    		session = factory.openSession();
    		session.beginTransaction();
        	User user = session.get(User.class, 1);
        	System.out.println(user);
        	assertNotNull(user);
    	} catch (Exception e) {
    		System.out.println("error: " + e.getMessage());
    		assertFalse(e.getMessage(), true);
    	} finally {
    		session.close();
    	}
    }
    /*
    public void testUserInsert2()
    {
    	UserDetails user = new UserDetails();
    	user.setUserName("Athrav Awasthi");
    	user.setJoinedDate(new Date());
    	user.setHomeAddress(new Address("gaur city2", "Ghaziabad", "UP", "201009"));
    	user.setOfficeAddress(new Address());
    	user.setDescription("Son");
    	Session session = null;
    	try {
    		session = factory.openSession();
    		session.beginTransaction();
        	session.save(user);
        	session.getTransaction().commit();
    	} catch (Exception e) {
    		System.out.println("error: " + e.getMessage());
    		session.getTransaction().rollback();
    		assertFalse(e.getMessage(), true);
    	} finally {
    		session.close();
    	}
        assertTrue( true );
    }*/
}

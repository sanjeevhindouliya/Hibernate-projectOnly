package com.ait.dao.impl;

import com.ait.dao.StudentDAO;
import com.ait.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.service.ServiceRegistry;


public class StudentDAOImpl implements StudentDAO {

	SessionFactory factory;
	
	public StudentDAOImpl() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		factory = metadata.getSessionFactoryBuilder().build();
	}
	
	@Override
	public void saveStudent(Student student) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(student);
			System.out.println("Student object is persisted in Database");
			t.commit();
		}
		catch(Exception ex) {
			t.rollback();
			System.out.println("Issue in persising Student object...");
			System.out.println(ex);
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

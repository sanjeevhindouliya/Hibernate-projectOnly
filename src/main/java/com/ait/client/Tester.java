package com.ait.client;

import com.ait.dao.StudentDAO;
import com.ait.dao.impl.StudentDAOImpl;
import com.ait.entity.Student;

public class Tester {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAOImpl();
		
		/*
		 * create student object
		 */
		Student student = new Student();
	    student.setSid(11011);
	    student.setSname("RAHUL");
	    student.setGender("Male");
	    student.setMarks(600);
	    
	    dao.saveStudent(student);
		
	}

}

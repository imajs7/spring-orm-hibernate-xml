package com.springorm.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.model.Student;

public class App {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	
    public static void main( String[] args ) {

    	
    	//insertRecord();
    	
    	//updateRecord();
    	
    	//selectRecord();
    	
    	selectAllRecords();
    	
    	//deleteRecord();
    	
    	
    	
    }
    
    public static void insertRecord() {
    	Student student = new Student("Amitabh Bachchan", "Mumbai");
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	int r = studentDao.insert(student);
    	System.out.println("Number of records inserted: "+r);
    }
    
    public static void selectRecord() {
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	Student student = studentDao.fetchStudentById(1);
    	System.out.println(student.toString());
    }
    
    public static void selectAllRecords() {
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	for(Student s : studentDao.fetchAllStudents()) {
    		System.out.println(s.toString());
    	}
    }
    
    public static void updateRecord() {
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	Student student = studentDao.fetchStudentById(1);
    	student.setCity("Saltlake, Kolkata");
    	studentDao.update(student);
    	System.out.println("Update done");
    }
    
    public static void deleteRecord() {
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	Student student = studentDao.fetchStudentById(1);
    	studentDao.delete(student);
    	System.out.println("Deleted");
    }
    
}

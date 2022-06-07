package com.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.model.Student;

public class StudentDao {
	
	private HibernateTemplate hTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer r = (Integer) this.hTemplate.save(student);
		return r;
	}
	
	public Student fetchStudentById(int studentId) {
		return this.hTemplate.get(Student.class, studentId);
	}
	
	public List<Student> fetchAllStudents(){
		return this.hTemplate.loadAll(Student.class);
	}
	
	@Transactional
	public void update(Student student) {
		this.hTemplate.update(student);
	}
	
	@Transactional
	public void delete(Student student) {
		this.hTemplate.delete(student);
	}

	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

}

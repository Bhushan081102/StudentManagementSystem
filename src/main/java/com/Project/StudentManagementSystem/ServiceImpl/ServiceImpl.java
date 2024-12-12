package com.Project.StudentManagementSystem.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentManagementSystem.Entity.Student;
import com.Project.StudentManagementSystem.Service.StudentService;
import com.Project.StudentManagementSystem.repository.StudentRepository;

@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repository; 

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	

}

package com.Project.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.StudentManagementSystem.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

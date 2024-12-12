package com.Project.StudentManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.StudentManagementSystem.Entity.Student;
import com.Project.StudentManagementSystem.Service.StudentService;

@Controller
public class ControllerLayer {

	@Autowired
	private StudentService service;
	

	@GetMapping("/student")
	public String getAllStudents(Model model) {
	    model.addAttribute("students", service.getAllStudents()); // Correct attribute name
	    return "student"; // Thymeleaf template name (student.html)
	}

	@GetMapping("student/new")
	public String createStudentForm(Model model) {
		Student student=new Student();//to hold the student object
		model.addAttribute("student",student);
		return "create-student";
		
	}
	
	@PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/student"; // Redirect to the list of students
		
	}
	@GetMapping("student/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		model.addAttribute("student",service.getById(id));
		return "edit_student";
		
	}
	@PostMapping("student/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student")Student student) {
		Student existingStudent= service.getById(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		service.saveStudent(existingStudent);
		return "redirect:/student";
		
	}
	
	@GetMapping("student/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/student";
		
	}

}

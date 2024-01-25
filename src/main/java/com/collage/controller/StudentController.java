package com.collage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collage.entity.Student;
import com.collage.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	public StudentRepo StdRepo;
	
	@PostMapping("/save-student")
	public String addStudent(@RequestBody Student std){
		StdRepo.save(std);
		return "Student with name " + std.getName() + " save successfully.";
	}
	
	@GetMapping("/get-all-student")
	public List<Student> getAllStudent(){
		return StdRepo.findAll();
	}
	
	@DeleteMapping("/delete-student-by-id")
	public String deleteStudentByID(@RequestParam("id") int id){
		StdRepo.deleteById(id);
		return "Student Deleted Successfully";	
	}
	@PutMapping("/update-student-by-name")
	public String updateName(@RequestParam String oldName, @RequestParam String newName) {
        int updatedCount = StdRepo.updateName(oldName, newName);
		return updatedCount + " Name update Successfully...";
		
	}
}

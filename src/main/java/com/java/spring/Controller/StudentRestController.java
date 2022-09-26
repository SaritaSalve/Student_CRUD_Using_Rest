package com.java.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.Service.StudentService;
import com.java.spring.beans.StudentBean;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	StudentService studentServie;
	
	@PostMapping("/")
	public String addStudent(@RequestBody StudentBean bean) {
		System.out.println(bean);
		studentServie.saveStudent(bean);
		return "Student saved....";
	}
	
	@GetMapping("/{studId}")
	public StudentBean searchStudentById(@PathVariable("studId") int studId) {
		StudentBean bean=studentServie.getStudentById(studId);
		System.out.println("stud by id----"+bean);
		return bean;
	}
	
	@PutMapping("/{studId}")
	public ResponseEntity updateStudentById(@RequestBody StudentBean bean, @PathVariable("studId") int studId) {
		System.out.println("stud by id----"+bean);
		StudentBean studentBean=studentServie.updateStudent(bean,studId);//get student from id for comparison
		if(studentBean.getStudId()==bean.getStudId()) {
//		String updateBean=studentServie.saveUpdatedStudent(bean);  
		System.out.println(studentBean);
		return new ResponseEntity(studentBean,HttpStatus.OK);
		}		
		return new ResponseEntity("No product found of given id...",HttpStatus.OK);

	}
	
	@GetMapping("/")
	public List<StudentBean> getListOfStudents(){
		List<StudentBean> studentBeans=studentServie.getAllStudents();
		return studentBeans;
	}
	
	@DeleteMapping("/{studId}")
	public String deleteStudentById(@PathVariable("studId") int studId) {
		String msg= studentServie.deleteStudentById(studId);
		System.out.println(msg);
		return "Student deleted...!";
	}
	
}

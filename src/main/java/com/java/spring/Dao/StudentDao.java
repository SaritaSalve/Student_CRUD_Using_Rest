package com.java.spring.Dao;

import java.util.List;

import com.java.spring.Entities.Student_Info;
import com.java.spring.beans.StudentBean;

public interface StudentDao {

	String saveStudentEntity(Student_Info info);

	Student_Info getStudentById(int studId);

	List<Student_Info> getListOfStudents();

	Student_Info saveUpdatedStudent(Student_Info info);

	String deleteStudentById(int studId);

}

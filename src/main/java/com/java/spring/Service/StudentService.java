package com.java.spring.Service;

import java.util.List;

import com.java.spring.beans.StudentBean;

public interface StudentService {

	String saveStudent(StudentBean bean);

	StudentBean getStudentById(int studId);

	StudentBean updateStudent(StudentBean bean,int studId);

	List<StudentBean> getAllStudents();

	String deleteStudentById(int studId);

//	String saveUpdatedStudent(StudentBean studentBean);


}

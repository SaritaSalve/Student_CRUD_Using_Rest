package com.java.spring.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.Dao.StudentDao;
import com.java.spring.Entities.Student_Info;
import com.java.spring.Service.StudentService;
import com.java.spring.beans.StudentBean;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;

	public String saveStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		Student_Info info=new Student_Info();
		info.setAddress(bean.getAddress());
		info.setFees(bean.getFees());
		info.setGender(bean.getGender());
		info.setStudId(bean.getStudId());
		info.setStudName(bean.getStudName());
		System.out.println("Service----"+info);
		return studentDao.saveStudentEntity(info);
		
	}

	public StudentBean getStudentById(int studId) {
		Student_Info info=studentDao.getStudentById(studId);
		
		return studEntiyToBean(info);
		// TODO Auto-generated method stub
		
	}

	private StudentBean studEntiyToBean(Student_Info info) {
		// TODO Auto-generated method stub
		StudentBean bean=new StudentBean();
		bean.setAddress(info.getAddress());
		bean.setFees(info.getFees());
		bean.setGender(info.getGender());
		bean.setStudId(info.getStudId());
		bean.setStudName(info.getStudName());
		return bean;
	}

	public StudentBean updateStudent(StudentBean bean,int studId) {
		// TODO Auto-generated method stub
		List<Student_Info> studList=studentDao.getListOfStudents();
System.out.println("list-----"+studList);
		for (Student_Info student_Info : studList) {
			if(student_Info.getStudId()==studId) {
				student_Info.setAddress(bean.getAddress());
				student_Info.setFees(bean.getFees());
				student_Info.setGender(bean.getGender());
				student_Info.setStudId(bean.getStudId());
				student_Info.setStudName(bean.getStudName());
				return studEntiyToBean(studentDao.saveUpdatedStudent(student_Info));
//				return bean;
			}
		}
		return null;
	}

	public List<StudentBean> getAllStudents() {
		// TODO Auto-generated method stub
		return studentListEntityToBean(studentDao.getListOfStudents());
	}

	private List<StudentBean> studentListEntityToBean(List<Student_Info> listOfStudents) {
		List<StudentBean> beans=new ArrayList<StudentBean>();
		for (Student_Info student_Info : listOfStudents) {
			StudentBean bean=new StudentBean();
			bean.setAddress(student_Info.getAddress());
			bean.setFees(student_Info.getFees());
			bean.setGender(student_Info.getGender());
			bean.setStudId(student_Info.getStudId());
			bean.setStudName(student_Info.getStudName());
			beans.add(bean);		}
		return beans;
	}

	public String deleteStudentById(int studId) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudentById(studId);
	}

//	@Override
//	public String saveUpdatedStudent(StudentBean studentBean) {
//		// TODO Auto-generated method stub
//		Student_Info info=new Student_Info();
//		info.setAddress(studentBean.getAddress());
//		info.setFees(studentBean.getFees());
//		info.setGender(studentBean.getGender());
//		info.setStudId(studentBean.getStudId());
//		info.setStudName(studentBean.getStudName());
//		System.out.println(info);
//		System.out.println(info);
//		return studentDao.saveUpdatedStudent(info);
//	}
}

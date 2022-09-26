package com.java.spring.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.Dao.StudentDao;
import com.java.spring.Entities.Student_Info;
import com.java.spring.util.HibernateUtil;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory factory;

	public String saveStudentEntity(Student_Info info) {

		Session session=null;
		Transaction tr=null;
		try {
			session= factory.openSession();
			tr=session.beginTransaction();
			session.save(info);
			return "Student Saved";
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return "Student saved....";
	}

	public Student_Info getStudentById(int studId) {

		Session session=null;
		Transaction tr=null;
		try {
			session= factory.openSession();
			tr=session.beginTransaction();

			Student_Info info=session.get(Student_Info.class, studId);
			return info;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return null;
	}

	public List<Student_Info> getListOfStudents() {
		Session session=null;
		Transaction tr=null;
		List<Student_Info> infos=new ArrayList<Student_Info>();
		try {
			session=factory.openSession();
			tr=session.beginTransaction();
			Criteria criteria=session.createCriteria(Student_Info.class);
			 infos=criteria.list();
			return infos;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return infos;
	}

	public Student_Info saveUpdatedStudent(Student_Info info) {

		Session session=null;
		Transaction tr=null;
		try {
			session= factory.openSession();
			tr=session.beginTransaction();
			session.update(info);
			Student_Info student_Info=session.get(Student_Info.class, info.getStudId());
			return student_Info;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return null;
	}

	public String deleteStudentById(int studId) {

		Session session=null;
		Transaction tr=null;
		try {
			session= factory.openSession();
			tr=session.beginTransaction();
			Student_Info student_Info=session.get(Student_Info.class, studId);
			session.delete(student_Info);
			return "Student Deleted.....!";
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return "Student Deleted.....!";
	}

}

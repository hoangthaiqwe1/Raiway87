package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {

	private HibernateUtils hibernateUtils;

	public ExamRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Exam getExamByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Exam exam = session.get(Exam.class, id);

			return exam;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Exam getExamByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Exam exam = query.uniqueResult();

			return exam;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(exam);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateExam(short id, String newCode1,String newCode2,String newTitle,int newDuration) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Exam exam = (Exam) session.load(Exam.class, id);

			// update
			exam.setCode1(newCode1);
			exam.setCode2(newCode2);
			exam.setName(newTitle);
			exam.setDuration(newDuration);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(exam);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteExam(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get department
			Exam exam = (Exam) session.load(Exam.class, id);

			// delete
			session.delete(exam);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isExamExistsByID(short id) {

		// get department
		Exam exam = getExamByID(id);

		// return result
		if (exam == null) {
			return false;
		}

		return true;
	}

	public boolean isExamExistsByName(String name) {
		Exam exam = getExamByName(name);

		if (exam == null) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked" })
	public int getCountByType(int duration) {
	    Session session = null;
	    try {
	        session = hibernateUtils.openSession();
	                
	        // Gỡ lỗi: In ra truy vấn và các tham số
	        System.out.println("Querying count by type with duration: " + duration);
	                
	        // Tạo HQL query
	        Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE Duration = :durationParameter");
	        // Thiết lập tham số
	        query.setParameter("durationParameter", duration);
	        // Lấy kết quả
	        return query.uniqueResult().intValue();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}


}

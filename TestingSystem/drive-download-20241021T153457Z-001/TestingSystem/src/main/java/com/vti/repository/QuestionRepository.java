package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;

public class QuestionRepository {

	private HibernateUtils hibernateUtils;

	public QuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Question getQuestionByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Question question = session.get(Question.class, id);

			return question;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Question getQuestionByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Question question = query.uniqueResult();

			return question;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(question);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Question question = (Question) session.load(Question.class, id);

			// update
			question.setName(newName);
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(question);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteQuestion(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get department
			Question question = (Question) session.load(Question.class, id);

			// delete
			session.delete(question);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isQuestionExistsByID(short id) {

		// get department
		Question question = getQuestionByID(id);

		// return result
		if (question == null) {
			return false;
		}

		return true;
	}

	public boolean isQuestionExistsByName(String name) {
		Question question = getQuestionByName(name);

		if (question == null) {
			return false;
		}
		return true;
	}

}

package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;

public class AnswerRepository {

	private HibernateUtils hibernateUtils;

	public AnswerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Answer> getAllAnswers() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Answer> query = session.createQuery("FROM Answer");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Answer getAnswerByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Answer answer = session.get(Answer.class, id);

			return answer;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Answer getAnswerByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Answer> query = session.createQuery("FROM Answer WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Answer answer = query.uniqueResult();

			return answer;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAnswer(Answer answer) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(answer);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAnswer(short id, String newName, boolean isCorrect) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Answer answer = (Answer) session.load(Answer.class, id);

			// update
			answer.setName(newName);
			answer.setCorrect(isCorrect);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAnswer(Answer answer) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(answer);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAnswer(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get department
			Answer answer = (Answer) session.load(Answer.class, id);

			// delete
			session.delete(answer);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAnswerExistsByID(short id) {

		// get department
		Answer answer = getAnswerByID(id);

		// return result
		if (answer == null) {
			return false;
		}

		return true;
	}

	public boolean isAnswerExistsByName(String name) {
		Answer answer = getAnswerByName(name);

		if (answer == null) {
			return false;
		}
		return true;
	}

}

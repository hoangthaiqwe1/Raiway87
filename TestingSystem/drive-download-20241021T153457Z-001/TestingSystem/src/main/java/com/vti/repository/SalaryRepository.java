package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalarys() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Salary getSalaryByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Salary salary = session.get(Salary.class, id);

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Salary getSalaryByName(int salaryName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary WHERE salaryName = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", salaryName);

			// get result
			Salary salary = query.uniqueResult();

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(salary);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(short id, int newSalaryName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Salary salary = (Salary) session.load(Salary.class, id);

			// update
			salary.setSalaryName(newSalaryName);
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateSalary (Salary salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(salary);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteSalary(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get department
			Salary salary = (Salary) session.load(Salary.class, id);

			// delete
			session.delete(salary);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isSalaryExistsByID(short id) {

		// get department
		Salary salary = getSalaryByID(id);

		// return result
		if (salary == null) {
			return false;
		}

		return true;
	}

	public boolean isSalaryExistsByName(int salaryName) {
		Salary salary = getSalaryByName(salaryName);

		if (salary == null) {
			return false;
		}
		return true;
	}

}

package com.vti.repository;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.query.Query;
 
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
 
public class PositionRepository {
 
	private HibernateUtils hibernateUtils;
 
	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
 
	@SuppressWarnings("unchecked")
	public List<Position> getAllPositions() {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
 
			// create hql query
			Query<Position> query = session.createQuery("FROM Position");
 
			return query.list();
 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public Position getPositiontByID(short id) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
 
			// get department by id
			Position position = session.get(Position.class, id);
 
			return position;
 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	@SuppressWarnings("unchecked")
	public Position getPositionByName(String name) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
 
			// create hql query
			Query<Position> query = session.createQuery("FROM Position WHERE name = :nameParameter");
 
			// set parameter
			query.setParameter("nameParameter", name);
 
			// get result
			Position position = query.uniqueResult();
 
			return position;
 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public void createPositiont(Position position) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
 
			// create
			session.save(position);
 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public void updatePosition(short id, String newName) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
 
			// get department
			Position position = (Position) session.load(Position.class, id);
 
			// update
			position.setName(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public void updatePosition(Position position) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// update
			session.update(position);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public void deletePosition(short id) {
 
		Session session = null;
 
		try {
 
			// get session
			session = hibernateUtils.openSession();
 
			session.beginTransaction();
 
			// get department
			Position position = (Position) session.load(Position.class, id);
 
			// delete
			session.delete(position);
 
			session.getTransaction().commit();
 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	public boolean isPositionExistsByID(short  id) {
 
		// get department
		Position position = getPositiontByID(id);
 
		// return result
		if (position == null) {
			return false;
		}
 
		return true;
	}
 
	public boolean isPositionExistsByName(String name) {
		Position position = getPositionByName(name);
 
		if (position == null) {
			return false;
		}
		return true;
	}
 
}
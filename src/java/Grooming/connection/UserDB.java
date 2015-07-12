package Grooming.connection;

import Grooming.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rohit Ruparel
 */
public class UserDB {

	public List < User > userGroup;

	public static void addUser(String firstName, String lastName, String emailAddress, String address1Field, String address2Field, String city, String state, int postCode, String country, String password) {
		User user;
		user = new User(firstName, lastName, emailAddress, address1Field, address2Field, city, state, postCode, country, password);
		addUser(user);
	}
	public static void addUser(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static User getUser(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			User user = em.find(User.class, userID);
			return user;
		} finally {
			em.close();
		}
	}

	public static List < User > getUsers() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from User u";
		TypedQuery < User > q = em.createQuery(qString, User.class);

		List < User > userGroup = new ArrayList < User > ();
		try {
			userGroup = (List < User > ) q.getResultList();
			if (userGroup == null || userGroup.isEmpty()) userGroup = null;
		} finally {
			em.close();
		}
		return userGroup;
	}


	public static User getUser(String emailAddress) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from User u " +
			"WHERE u.emailAddress = :emailAddress";
		TypedQuery < User > q = em.createQuery(qString, User.class);
		q.setParameter("emailAddress", emailAddress);

		User user = new User();
		try {

			user = q.getSingleResult();
			if (user == null) {
				return null;
			} else {
				return user;
			}
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public static void update(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}
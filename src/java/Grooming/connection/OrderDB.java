

package Grooming.connection;

import Grooming.model.Order;
import Grooming.model.OrderItem;
import Grooming.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
/**
 *
 * @author Rohit Ruparel
 */
public class OrderDB {


	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */


	public List < Order > orderGroup;

	public static void addOrder(int orderNumber, Date date, User user, List < OrderItem > orderItem, float taxRate, float totalCost, boolean paid) {
		Order order;
		order = new Order(orderNumber, date, user, orderItem, taxRate, totalCost, paid);
		addOrder(order);
	}
	public static void addOrder(Order order) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			int userID = order.getUser().getUserID();
			order.setUserID(userID);
			em.persist(order);
			trans.commit();
			addOrderItem(order);
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
		}
	}
	public static Order getOrder(int orderNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Order order = em.find(Order.class, orderNumber);
			return order;
		} finally {
			em.close();
		}
	}

	public static List < Order > getOrders() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from Order u";
		TypedQuery < Order > q = em.createQuery(qString, Order.class);

		List < Order > orderGroup = new ArrayList < Order > ();
		try {
			orderGroup = (List < Order > ) q.getResultList();
			if (orderGroup == null || orderGroup.isEmpty()) orderGroup = null;
		} finally {
			em.close();
		}
		return orderGroup;
	}

	public static List < Order > getUserOrders(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from Order u " +
			"WHERE u.userID = :userID";
		TypedQuery < Order > q = em.createQuery(qString, Order.class);
		q.setParameter("userID", userID);

		List < Order > orderGroup = new ArrayList < Order > ();
		try {
			orderGroup = (List < Order > ) q.getResultList();
			if (orderGroup == null || orderGroup.isEmpty()) orderGroup = null;
		} finally {
			em.close();
		}
		return orderGroup;
	}

	public static void update(Order order) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(order);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Order order) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(order));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void addOrderItem(Order order) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		List < OrderItem > orderItems = new ArrayList < OrderItem > ();
		orderItems = order.getOrderItems();
		try {

			for (OrderItem orderItem: orderItems) {
				orderItem.setOrderNumber(order.getOrderNumber());
				orderItem.setProductCode(orderItem.getProduct().getProductCode());
				em.persist(orderItem);
			}
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}
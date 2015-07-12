package Grooming.connection;

import Grooming.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rohit Ruparel
 */
public class ProductDB {

	public List < Product > productGroup;

	public static void addProduct(String productCode, String productName, String catalogCategory, String description, int price, String imageURL) {
		Product product;
		product = new Product(productCode, productName, catalogCategory, description, price, imageURL);
		addProduct(product);
	}
	public static void addProduct(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(product);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Product getProduct(String productCode) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Product product = em.find(Product.class, productCode);
			return product;
		} finally {
			em.close();
		}
	}

	public static List < Product > getProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from Product u";
		TypedQuery < Product > q = em.createQuery(qString, Product.class);

		List < Product > productGroup = new ArrayList < Product > ();
		try {
			productGroup = (List < Product > ) q.getResultList();
			if (productGroup == null || productGroup.isEmpty()) productGroup = null;
		} finally {
			em.close();
		}
		return productGroup;
	}

	public static void update(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(product);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(product));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}
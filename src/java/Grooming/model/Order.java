package Grooming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rohit Ruparel
 */
@Entity@Table(name = "orders")
public class Order implements Serializable {

	@Id@Column(name = "orderNumber")@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNumber = 0;

	@Column(name = "date")@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "taxRate")
	private float taxRate;

	@Column(name = "totalCost")
	private float totalCost;

	@Column(name = "paid")
	private boolean paid = false;

	@Column(name = "userID")
	private int userID;

	@Transient
	private User user;

	@Transient
	private List < OrderItem > orderItems;

	public Order() {}

	public Order(int orderNumber, Date date, User user, List < OrderItem > orderItems, float taxRate, float totalCost, boolean paid) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.user = user;
		this.orderItems = orderItems;
		this.taxRate = taxRate;
		this.totalCost = totalCost;
		this.paid = paid;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Date getDate() {
		return date;
	}

	public User getUser() {
		return user;
	}

	public List < OrderItem > getOrderItems() {
		return orderItems;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setOrderItems(List < OrderItem > orderItems) {
		this.orderItems = orderItems;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grooming.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rohit Ruparel
 */
@Entity
@Table(name="orderitem")
public class OrderItem implements Serializable {

    @Id
    @Column(name="orderNumber")
    private int orderNumber;
    
    @Id
    @Column(name="productCode")
    private String productCode;
    
    @Column(name="quantity")
    int quantity;
    
    @Transient
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setProductCode(String productCode){
        this.productCode=productCode;
    }
    
    public String getProductCode(){
        return productCode;
    }
      
    public float getTotal() {
        float totalAmount = 0;
        totalAmount = (product.getPrice() * quantity);
        return totalAmount;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber){
        this.orderNumber=orderNumber;
    }
}

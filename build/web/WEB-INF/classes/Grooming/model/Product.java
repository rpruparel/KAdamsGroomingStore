/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grooming.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Rohit Ruparel
 */
@Entity
@Table(name="product")
public class Product implements Serializable {
    
    @Id
    @Column(name="productCode")
    private String productCode;
    
    @Column(name="productName")
    private String productName; 
    
    @Column(name="catalogCategory")
    private String catalogCategory;
    
    @Column(name="description")
    private String description;

    @Column(name="price")
    private float price;
    
    @Column(name="imageURL")
    private String imageURL;
    


    public Product() {
    }

    public Product(String productCode, String productName, String catalogCategory, String description, int price, String imageURL) {
        this.productCode = productCode;
        this.productName = productName;
        this.catalogCategory = catalogCategory;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCatalogCategory() {
        return catalogCategory;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCatalogCategory(String catalogCategory) {
        this.catalogCategory = catalogCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
//     public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
}

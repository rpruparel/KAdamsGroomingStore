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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Rohit Ruparel
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    
    @Id
    @Column(name="userID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID=0;
    
    @Column(name="postCode")
    private int postCode;
    
    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Column(name="emailAddress")
    private String emailAddress;
    
    @Column(name="address1Field")
    private String address1Field;
    
    @Column(name="address2Field")
    private String address2Field;
   
    @Column(name="city")
    private String city;
    
    @Column(name="state")
    private String state;
    
    @Column(name="country")
    private String country;
    
    @Column(name="password")
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String address1Field, String address2Field, String city, String state, int postCode, String country, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address1Field = address1Field;
        this.address2Field = address2Field;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
        this.password = password;
    }

    public int getUserID(){
        return userID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress1Field() {
        return address1Field;
    }

    public String getAddress2Field() {
        return address2Field;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPostCode() {
        return postCode;
    }
    
    public String getPassword(){
        return password;
    }

    public void setUserID(int userID){
        this.userID=userID;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress1Field(String address1Field) {
        this.address1Field = address1Field;
    }

    public void setAddress2Field(String address2Field) {
        this.address2Field = address2Field;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
    
    public void setPassword(String password){
        this.password=password;
    }   
}

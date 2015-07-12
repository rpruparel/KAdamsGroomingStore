/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grooming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rohit Ruparel
 */
public class Cart implements Serializable {
    
    private List<OrderItem> cart = new ArrayList<OrderItem>();

    public Cart() {
        this.cart = cart;
    }

    public Cart(List<OrderItem> cart) {
        this.cart = cart;
    }

    public List<OrderItem> getOrderItem() {
        return cart;
    }

    public void setOrderItem(List<OrderItem> cart) {
        this.cart = cart;
    }

    public void addItem(Product product, int quantity) {
        int cartItemCheck = 0;
        for (int n = 0; n < cart.size(); n++) {
            OrderItem orderItem = cart.get(n);
            Product addedProduct = orderItem.getProduct();
            if (product.getProductCode().equals(addedProduct.getProductCode())) {
                orderItem.setQuantity(quantity);
                cartItemCheck = 1;
            }

            if (cartItemCheck == 1) {
                break;
            }
        }
        if (cartItemCheck == 0) {
            OrderItem orderItem = new OrderItem(product, quantity);
            if (cart == null) {
                cart = new ArrayList<OrderItem>();
            }
            cart.add(orderItem);
        }
    }

    public boolean removeItem(Product product) {
        String productCode = product.getProductCode();
        for (int n = 0; n < cart.size(); n++) {
            OrderItem orderItem = cart.get(n);
            Product addedProduct = orderItem.getProduct();
            if (product.getProductCode().equals(addedProduct.getProductCode())) {
                cart.remove(orderItem);
                return true;
            }

        }
        return false;
    }

    public List<OrderItem> getItems() {
        return cart;
    }

    public void emptyCart() {
        cart.clear();
    }

    public int getCount() {
        return cart.size();
    }
}

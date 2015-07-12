/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grooming.controller;

import Grooming.connection.OrderDB;
import Grooming.connection.PasswordUtil;
import Grooming.connection.ProductDB;
import Grooming.connection.UserDB;
import Grooming.model.Cart;
import Grooming.model.Order;
import Grooming.model.OrderItem;
import Grooming.model.Product;
import Grooming.model.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rohit Ruparel
 */
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Loads the database of products.*/
        ProductDB prodDB = new ProductDB();
        List<Product> productGroup = prodDB.getProducts();

        /*check if not a valid shopping cartList ******************************/
        HttpSession session = request.getSession();
        Cart theShoppingCart = (Cart) session.getAttribute("theShoppingCart");
        int cartCheck = 0;
        if (theShoppingCart == null) {
            theShoppingCart = new Cart();
            session.setAttribute("theShoppingCart", theShoppingCart);
            cartCheck = 1;
        }
        /*Checks the http request for a parameter called “action”*/
        String action = null;
        int quantity = 0;
        int productCount = 0;
        int validQuantity = 0;
        List<OrderItem> cartList;
        cartList = (List<OrderItem>) ((Cart) session.getAttribute("theShoppingCart")).getItems();

        action = (String) request.getParameter("action");
        if (action == null) {
            response.sendRedirect("cart.jsp");
            return;
        }

        if (action.equals("updateCart") || action.equals("checkout") || action.equals("confirmOrder") || action.equals("viewOrders") || action.equals("Login") || action.equals("logout") || action.equals("register")) {
            if (action.equals("updateCart")) {
                String[] productList = null;
                productList = request.getParameterValues("productList");
                {
                    if (productList == null) {
                        response.sendRedirect("cart.jsp");
                        return;
                    }

                }

                for (int n = 0; n < productList.length; n++) {
                    for (int m = 0; m < productGroup.size(); m++) {
                        Product product = productGroup.get(m);
                        if (productList[n].equals(product.getProductCode())) {
                            if (cartCheck == 1) {
                                if (request.getParameter(product.getProductCode()) == null) {
                                    OrderItem orderItem = new OrderItem(product, 1);
                                    theShoppingCart.addItem(product, 1);
                                }
                            } else {
                                if (request.getParameter(product.getProductCode()) == null || request.getParameter(product.getProductCode()) == "") {
                                    quantity = 1;
                                    productCount = 1;
                                } else if (request.getParameter(product.getProductCode()).matches("[0-9]+")) {
                                    quantity = Integer.parseInt((String) request.getParameter(product.getProductCode()));
                                } else {
                                    break;
                                }

                                if (quantity == 0) {
                                    for (OrderItem oi : cartList) {
                                        if (oi.getProduct().getProductCode().equals(product.getProductCode())) {
                                            theShoppingCart.removeItem(oi.getProduct());
                                            break;

                                        }
                                    }

                                } else if (quantity == 1 && productCount == 1) {

                                    int itemExistsCheck = 0;
                                    for (OrderItem oi : cartList) {
                                        if (oi.getProduct().getProductCode().equals(product.getProductCode())) {
                                            oi.setQuantity(oi.getQuantity() + 1);
                                            itemExistsCheck = 1;
                                            break;

                                        }
                                    }
                                    if (itemExistsCheck == 0) {
                                        OrderItem orderItem = new OrderItem(product, 1);
                                        theShoppingCart.addItem(product, 1);
                                    }

                                } else {
                                    for (OrderItem oi : cartList) {
                                        if (oi.getProduct().getProductCode().equals(product.getProductCode())) {
                                            if (oi.getQuantity() != quantity) {
                                                oi.setQuantity(quantity);
                                                break;
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                response.sendRedirect("cart.jsp");
                return;
            } else if (action.equals("checkout")) {
                User user = (User) session.getAttribute("theUser");
                if (user == null) {
                    response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/login.jsp");
                    return;
                }
//                UserDB userDB = new UserDB();
//                List<User> userGroup = userDB.getUsers();
//                User theUser = userGroup.get(0);
//                session.setAttribute("theUser", theUser);

                float totalCost = 0;
                for (OrderItem orderItem : cartList) {
                    totalCost = totalCost + orderItem.getTotal();
                }
                

                Date now = new Date();
                Order currentOrder = new Order(1, now, user, cartList, (float) 10.7, totalCost, true);
                session.setAttribute("currentOrder", currentOrder);
                response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/order.jsp");
                return;
            } else if (action.equals("confirmOrder")) {
                OrderDB orderDB = new OrderDB();
                Order order = (Order) session.getAttribute("currentOrder");
                orderDB.addOrder(order);
                response.sendRedirect("http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/order.jsp?message=Paid in full");
                return;
            } else if (action.equals("viewOrders")) {
                User user = (User) session.getAttribute("theUser");
                if (user != null) {
                    OrderDB orderDB = new OrderDB();
                    List<Order> orderGroup;
                    orderGroup = orderDB.getUserOrders(user.getUserID());
                    request.setAttribute("theOrders", orderGroup);
                    RequestDispatcher userOrders;
                    userOrders = request.getRequestDispatcher("orderlist.jsp");
                    userOrders.forward(request, response);
                } else {
                    response.sendRedirect("CatalogController?catalogCategory=All%Products");
                    return;
                }
            } else if (action.equals("Login")) {
                String userName = request.getParameter("username");
                String password = request.getParameter("passcard");         
                PasswordUtil passwordUtil = new PasswordUtil();
//                             

                
                UserDB userDB = new UserDB();
                User user = userDB.getUser(userName);
                if(user == null ) {
                    response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/login.jsp?message=error");
                    return;
                }
                
                String dbPasscard = user.getPassword();
                String Hpasscard = null;
                try {
                    Hpasscard = passwordUtil.hashPassword(password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (dbPasscard.equals(Hpasscard)) {
                    session.setAttribute("theUser", user);
                    response.sendRedirect("OrderController?action=checkout");
                    return;
                }
                else{
                    response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/login.jsp?message=error");
                    return;
                }
            } else if (action.equals("logout")) {
                User user = (User) session.getAttribute("theUser");
                user = null;
                session.setAttribute("theUser", user);
                response.sendRedirect("CatalogController?catalogCategory=All%Products");
                return;
            } else if (action.equals("register")) {
                String username = request.getParameter("username");
                String passcard = request.getParameter("passcard");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String addLine1 = request.getParameter("addLine1");
                String addLine2 = request.getParameter("addLine2");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String country = request.getParameter("country");
                int zipCode = Integer.parseInt(request.getParameter("zipCode"));

                String Hpasscard = null;
                PasswordUtil passwordUtil = new PasswordUtil();
                try {
                    Hpasscard = passwordUtil.hashPassword(passcard);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                }

                User user = new User(firstName, lastName, username, addLine1, addLine2, city, state, zipCode, country, Hpasscard);

                UserDB userDB = new UserDB();
                userDB.addUser(user);

                session.setAttribute("theUser", user);

                response.sendRedirect("OrderController?action=checkout");
                return;
            }
        } else {
            response.sendRedirect("cart.jsp");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Grooming.model.User"%>
<%@page import="Grooming.model.Cart"%>
<%@page import="Grooming.model.Cart"%>
<%@page import="Grooming.model.OrderItem"%>
<%@page import="Grooming.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Neal Adam's
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Style.css" type='text/css' rel='stylesheet' />
    </head>

    <body class="Background">
        <% User user = (User) session.getAttribute("theUser");
        List<OrderItem> cartList = null;

                            Cart cart = (Cart) session.getAttribute("theShoppingCart");
                            if (cart != null) {
                                cartList = (List<OrderItem>) cart.getItems();
                            }
        Order currentOrder = (Order) session.getAttribute("currentOrder");
        if(user == null || currentOrder == null || cartList == null || cart.getCount() == 0) {
            response.sendRedirect("CatalogController?catalogCategory=All%Products");
            return;
        }%>
        <div class="Headers">
            <%@include file="/header.jsp" %>
        </div>
        <%@include file="/user-navigation.jsp" %>
        <%@include file="/site-navigation.jsp" %>
        <div class="Main">
            
            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/index.jsp'> Home </a>
            >
            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/cart.jsp'> My Cart </a>
            >
            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/order.jsp'> Order </a>
            <div class="bodytext">
                <br>
                <b>
                    Enter your payment information:
                </b>
                <form action="OrderController" method="GET">
                <hr>
                <table>
                    <tr>
                        <td>
                                <span>Credit Card Type</span>
                        </td>
                        <td>
                            <select>
                                <option value="1">Visa</option>
                                <option value="1">MasterCard</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                                <span>Credit Card Number</span>
                        </td>
                        <td>
                            <input type="number" id="ccnumber" name="ccnumber" maxlength="16" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                                <span>Expiration Date</span>
                        </td>
                        <td>
                            <select id="month" name="month">
                                <option value="01">Jan</option>
                                <option value="02">Feb</option>
                                <option value="03">Mar</option>
                                <option value="04">Apr</option>
                                <option value="05">May</option>
                                <option value="06">Jun</option>
                                <option value="07">Jul</option>
                                <option value="08">Aug</option>
                                <option value="09">Sep</option>
                                <option value="10">Oct</option>
                                <option value="11">Nov</option>
                                <option value="12">Dec</option>
                            </select>
                            <select id="year" name="year">
                                <option value="2014">2014</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                                <span>CVV (3 digit pin)</span>
                        </td>
                        <td>
                             <input type="number" id="cvv" name="cvv" maxlength="3" required />
                        </td>
                    </tr>
                </table>
                <hr>
                 <%  float cartTotal = 0;
                if(currentOrder!=null && cartList != null && cart.getCount() != 0)
                {   
                    User theUser = (User) currentOrder.getUser();
                    if (theUser != null) 
                    { 
                        cartTotal = (currentOrder.getTotalCost() + currentOrder.getTaxRate());
                    }
                }
                %> 
                Your card will charged with a total of <%=cartTotal%><br><br>
                <div class="bodytextleft">
                <input type="hidden" name="action" id="action" value="confirmOrder" />
                <input type="submit" value="Confirm Payment" name="submit"/>
                </div>
                </form>
            </div>
        </div>
        <%@include file="/footer.jsp" %>
    </body>
</html>
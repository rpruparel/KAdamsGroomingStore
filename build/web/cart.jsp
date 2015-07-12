<%-- Document : cart Created on : 15 Sep, 2014, 8:53:14 PM Author : Acer
--%>
<%@page import="java.util.List"%>
<%@page import="Grooming.model.Cart"%>
<%@page import="Grooming.model.OrderItem"%>
<%@page import="java.util.ArrayList"%>
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
        <div class="Headers">
            <%@include file="/header.jsp" %>
        </div>
        <%@include file="/user-navigation.jsp" %>
        <%@include file="/site-navigation.jsp" %>
        <div class="Main">
            <a href='index.jsp'> Home </a>
            >
            <a href='cart.jsp'> My Cart </a>
            <br>
            <br>
            <div class="bodytext">
                <b>
                    Your Shopping Cart:
                </b>
                <hr>
                <form action="OrderController" method="GET">
                    <table class="Table">

                        <%  float cartTotal = 0;
                            List<OrderItem> cartList = null;

                            Cart cart = (Cart) session.getAttribute("theShoppingCart");
                            if (cart != null) {
                                cartList = (List<OrderItem>) cart.getItems();
                            }

                            if (cartList == null || cart.getCount() == 0) {%>
                        <tr>
                            <td>
                                Your shopping cart is empty.
                            </td>
                        </tr>
                        <%} else {%>
                        <tr>
                            <td>
                                <b>
                                    Item
                                </b>
                            </td>
                            <td>
                                <b>
                                    Price
                                </b>
                            </td>
                            <td>
                                <b>
                                    Quantity
                                </b>
                            </td>
                            <td>
                                <b>
                                    Total
                                </b>
                            </td>
                        </tr>
                        <% for (int p = 0; p < cartList.size(); p++) {%>
                        <tr>
                            <td>
                                <%=cartList.get(p).getProduct().getProductName()%>
                                <input type="hidden" name="productList" value="<%=cartList.get(p).getProduct().getProductCode()%>" />
                            </td>
                            <td>
                                $<%=cartList.get(p).getProduct().getPrice()%>
                            </td>
                            <td>
                                <input type="number" name="<%=cartList.get(p).getProduct().getProductCode()%>" value="<%=cartList.get(p).getQuantity()%>" required min="0">
                            </td>
                            <td>
                                $<%=cartList.get(p).getTotal()%>
                                <%cartTotal = cartTotal + cartList.get(p).getTotal();%>
                            </td>
                        </tr>
                        <%}%>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                                <b>
                                    SubTotal
                                </b>
                            </td>
                            <td>
                                $<%=cartTotal%>
                            </td>
                        </tr>
                        <%} %>
                    </table>

                    
                        <% if (cartList != null && cart.getCount() > 0) { %>
                        <hr>
                        <div class="bodytextleft">
                        <table>
                            <tr>
                                <td>
                                    <input type="hidden" name="action" value="updateCart" />
                                    <input type="Submit" value="Update Cart" />
                                </td>
                            </tr>
                        </table>
                        </div>
                        <%}%>
                        </form>
                        <% if (cartList != null && cart.getCount() > 0) { %>
                        <form action="OrderController" method="GET">
                        <div class="bodytextleft">
                        <table>
                            <tr>
                                <td>
                                    <input type="hidden" name="action" value="checkout" />
                                    <input type="submit" value="Checkout" />
                                </td>
                            </tr>
                        </table>
                        </div>
                        </form>
                        <%}%>
                        
                
        </div>
    </div>
    <%@include file="/footer.jsp" %>
</body>

</html>
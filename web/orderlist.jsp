<%@page import="Grooming.connection.UserDB"%>
    <%@page import="Grooming.model.User"%>
        <%@page import="Grooming.model.Cart"%>
            <%@page import="Grooming.model.Cart"%>
                <%@page import="Grooming.model.OrderItem"%>
                    <%@page import="Grooming.model.Order"%>
                        <%@page import="java.util.ArrayList"%>
                            <%@page import="java.text.SimpleDateFormat"%>
                                <%@page import="java.util.List"%>
                                    <%@page import="java.util.Date"%>
                                        <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                                            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/index.jsp'> Home </a> >
                                                            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/order.jsp'> My Orders </a>

                                                            <br>
                                                            <div class="bodytext">
                                                                <% 
                    List<Order> orderGroup = (List) request.getAttribute("theOrders");
                    if (orderGroup == null) {
                    response.sendRedirect("CatalogController?catalogCategory=All%Products");
                    return;
                } else {%>
                                                                    <br>
                                                                    <b>
                    Order List
                </b>
                                                                    <hr>
                                                                    <table class="Table">
                                                                        <tr>
                                                                            <td>
                                                                                <b>
                                    Order Number
                                </b>
                                                                            </td>
                                                                            <td>
                                                                                <b>
                                    Customer
                                </b>
                                                                            </td>
                                                                            <td>
                                                                                <b>
                                    Order Date
                                </b>
                                                                            </td>
                                                                            <td>
                                                                                <b>
                                    Total
                                </b>
                                                                            </td>
                                                                        </tr>
                                                                        <% for(int n = 0; n<orderGroup.size(); n++) {
                        UserDB userDB = new UserDB();
                        Order order = orderGroup.get(n); 
                        User user = userDB.getUser(order.getUserID());
                        String fullName = new StringBuilder(user.getFirstName()).append(" ").append(user.getLastName()).toString();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,YYYY");
                        String date = dateFormat.format(order.getDate());%>
                                                                            <tr>
                                                                                <td>
                                                                                    <%=order.getOrderNumber()%>
                                                                                </td>
                                                                                <td>
                                                                                    <%=fullName%>
                                                                                </td>
                                                                                <td>
                                                                                    <%=date%>
                                                                                </td>
                                                                                <td>
                                                                                    $
                                                                                    <%=(order.getTotalCost() + order.getTaxRate())%>
                                                                                </td>
                                                                            </tr>
                                                                            <%}}%>
                                                                    </table>
                                                                    <hr>
                                                            </div>

                                                        </div>
                                                        <%@include file="/footer.jsp" %>
                                            </body>

                                            </html>
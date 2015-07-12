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
                        <% User user = (User) session.getAttribute("theUser");
        if(user != null){
            response.sendRedirect("CatalogController?catalogCategory=All%20Products");
            return;
        }%>
                            <div class="Headers">
                                <%@include file="/header.jsp" %>
                            </div>
                            <%@include file="/user-navigation.jsp" %>
                                <%@include file="/site-navigation.jsp" %>
                                    <div class="Main">
                                        <a href='index.jsp'> Home </a> >
                                        <a href='login.jsp'> Login </a>

                                        <br>
                                        <br>
                                        <div class="bodytext">
                                            <b>
                    Login
                </b>
                                            <hr>
                                            <%String message = null;
                message = request.getParameter("message");
                

                if(message!=null && message.equals("error")){
                    message="Username and password combination did not match. Please try again.";
                %>
                                                <p>
                                                    <%=message%>
                                                </p>
                                                <%}%>
                                                    <form action="OrderController" method="post">
                                                        <table>
                                                            <tr>
                                                                <td>
                                                                    <span><b>New User?</b></span>
                                                                </td>
                                                                <td>
                                                                    <a href="https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/registration.jsp">Register Here</a>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <hr>
                                                        <table>
                                                            <tr>
                                                                <td>
                                                                    <br><span>Username:</span>
                                                                </td>
                                                                <td>
                                                                    <br>
                                                                    <input type="email" name="username" id="username" placeholder="Enter username" maxlength="30" required />
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <br><span>Password:</span>
                                                                </td>
                                                                <td>
                                                                    <br>
                                                                    <input type="password" name="passcard" id="passcard" placeholder="Enter password" maxlength="15" required />
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <br>
                                                                    <br><span>&nbsp;</span>
                                                                </td>
                                                                <td>
                                                                    <br>
                                                                    <input type="submit" name="action" value="Login" />
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </form>
                                        </div>
                                    </div>
                                    <%@include file="/footer.jsp" %>
                    </body>

                    </html>
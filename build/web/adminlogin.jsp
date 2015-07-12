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
            <a href='login.jsp'> Admin Login </a>
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
                <p><%=message%></p>
                <%}%>
                <form action="j_security_check" method="post">
                    <table>
                        <tr>
                            <td>
                                <label>Username</label>
                            </td>
                            <td>
                                <input type="email" name="j_username" placeholder="Enter username" maxlength="30" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                 <br><label>Password</label>
                            </td>
                            <td>
                                <br><input type="password" name="j_password" placeholder="Enter password" maxlength="15" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><label>&nbsp;</label>
                            </td>
                            <td>
                                <br><input type="submit" value="Login">
                            </td>
                        </tr>
                    </table>
             </form>         
        </div>
    </div>
    <%@include file="/footer.jsp" %>
</body>

</html>
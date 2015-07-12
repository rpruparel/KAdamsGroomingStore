<%-- Document : header Created on : 15 Sep, 2014, 9:03:18 PM Author :
Acer --%>
<%@page import="Grooming.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

            <img src="images/Logo.jpg" alt="K Adam's Grooming" height="100" width="350">
            <span class="Signin">
                <%
                    String userName = null;
                    User sessionUser = (User) session.getAttribute("theUser");
                    if (sessionUser != null) {
                        userName = sessionUser.getFirstName();
                    }
                    if (userName != null) {%>
                
                    Hello&nbsp;<%=userName%>,&nbsp;&nbsp;&nbsp;&nbsp;<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="OrderController?action=logout">Log Out</a>
                
                <%} else {%>
               
                    Not Signed In
                
                <%}%>
            </span>


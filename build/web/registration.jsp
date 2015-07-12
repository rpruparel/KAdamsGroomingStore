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
            <a href='http://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/index.jsp'> Home </a>
            >
            <a href='https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/registration.jsp'> Registration </a>
            <br>
            <br>
            <div class="bodytext">
                
                <b>
                    Registration
                </b>
                <hr>
                <form action="OrderController?action=register" method="post">
                     <table>
                        <tr>
                            <td>
                                <span><b>Already Registered?</b></span>
                            </td>
                            <td>
                                <a href="https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/login.jsp">Login Here</a>
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
                                <br><input type="email" name="username" id="username" placeholder="Enter email"  maxlength="30" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Password:</span>
                            </td>
                            <td>
                                <br><input type="password" name="passcard" id="passcard" placeholder="Enter password"  maxlength="15" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>First Name:</span>
                            </td>
                            <td>
                                <br><input type="text" name="firstName" id="firstName" placeholder="Enter first name"  maxlength="20" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Last Name:</span>
                            </td>
                            <td>
                                <br><input type="text" name="lastName" id="lastName" placeholder="Enter last name"  maxlength="20" required  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Address Line 1:</span>
                            </td>
                            <td>
                                <br><input type="text" name="addLine1" id="addLine1" placeholder="Enter address"  maxlength="30" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Address Line 2:</span>
                            </td>
                            <td>
                                <br><input type="text" name="addLine2" id="addLine2" placeholder="Enter address"  maxlength="30" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>City:</span>
                            </td>
                            <td>
                                <br><input type="text" name="city" id="city" placeholder="Enter city"  maxlength="20" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>State:</span>
                            </td>
                            <td>
                                <br><input type="text" name="state" id="state" placeholder="Enter state"  maxlength="20" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Country:</span>
                            </td>
                            <td>
                                <br><input type="text" name="country" id="country" placeholder="Enter country"  maxlength="20" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br><span>Zip Code:</span>
                            </td>
                            <td>
                                <br><input type="text" name="zipCode" id="zipCode" placeholder="Enter zip code"  maxlength="11" required />
                            </td>
                        </tr>
                        <tr>
                            <td><br>
                                <br><span>&nbsp;</span>
                            </td>
                            <td><br>
                                <input type="submit" value="Register" />
                            </td>
                        </tr>
                    </table>    
                </form>         
        </div>
    </div>
    <%@include file="/footer.jsp" %>
</body>

</html>
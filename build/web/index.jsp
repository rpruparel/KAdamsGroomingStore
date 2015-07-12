<%-- 
    Document   : index
    Created on : 29 Aug, 2014, 7:22:48 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Neal Adam's </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Style.css" type='text/css' rel='stylesheet'/>
    </head>

    <body class="Background">

        <div class="Headers">
            <%@include file="/header.jsp" %>
        </div>

        <%@include file="/user-navigation.jsp" %>
        <%@include file="/site-navigation.jsp" %>


        <div class="Right"> 
            <a href='index.jsp'> Home </a> >  

            <div class="bodytext">        
                <h2> K Adam's Grooming </h2>
                <p> <h3>Welcome to K Adam's!!</h3>
                <b><i>K Adam's Offers:</i></b><br>

                20% Discount on Men's Health Care products
                <br>
                <br>
                <b><i>K Adam's New arrivals:</i></b><br>

                Check Men's Accessories for new arrival products.<br>
                New cufflinks designs available.
                <br>
                <br>
                Happy Shopping!!

                <span class="arrow previous"></span>
                <span class="arrow next"></span>
            </div>
        </div>

        <%@include file="/footer.jsp" %>
    </body>

</html>

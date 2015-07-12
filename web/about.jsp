<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <title> Neal Adam's </title>
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



                <div class="Right">
                    <a href='index.jsp'> Home </a> >
                    <a href='about.jsp'> About Us</a>

                    <div class="bodytext">
                        <h2> About K Adam's</h2>
                        <br>
                        <p> K Adam's objective is to make mens grooming products easily available,
                            <br>
                            <br> K Adam's provides various categories like Mens Clothing, Accessories,
                            <br>
                            <br> Healthcare Products etc.
                            <br>
                            <br> Check for new arrivals..Happy Shopping!!!
                        </p>

                    </div>
                </div>
                <%@include file="/footer.jsp" %>
    </body>

    </html>
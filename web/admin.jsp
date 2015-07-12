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
                    <a href='index.jsp'> Home </a> >
                    <a href='admin.jsp'> Admin Menu </a>

                    <div class="bodytext">
                        <br>
                        <b>
                    Administrator Menu
                </b>
                        <hr>
                        <form action="AdminController" method="GET">
                            <input type="hidden" name="action" value="viewOrders" />
                            <input type="submit" value="Display All Orders" name="submit" />
                        </form>
                    </div>
                </div>
                <%@include file="/footer.jsp" %>
    </body>

    </html>
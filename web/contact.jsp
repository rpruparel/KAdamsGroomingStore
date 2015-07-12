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
                <div class="Right">
                    <a href='index.jsp'> Home </a> >
                    <a href='contact.jsp'> Contact Us</a>

                    <div class="bodytext">
                        <h3>
                        Contact Us:
                    </h3>
                        <p>
                            <b>
                            <i>
                                K Adam's Grooming
                            </i>
                        </b>
                            <br> 9555, Neal Avenue,
                            <br> University Terrace Drive
                            <br> Charlotte,28262
                            <br> North Carolina
                        </p>
                        <br>
                        <u>
                        feedback@KAdamsgrooming.com
                    </u>
                        <br>
                        <h2>
                        Follow Us On:
                    </h2>
                        <img src="images/SN_Logo.jpg" alt="Social Networking" height="50" width="200">
                        <br>
                        <br> Customer Care: 1800 500 6002
                    </div>
                </div>
                <%@include file="/footer.jsp" %>
    </body>

    </html>
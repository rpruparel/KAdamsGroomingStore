<%-- Document : item Created on : 15 Sep, 2014, 8:56:47 PM Author : Acer--%>
<%@page import="Grooming.model.Product" %>
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
        <% Product product = (Product) request.getAttribute("product");%>
        <div class="Main">
            <a href='index.jsp'> Home </a>
            >
            <a href='CatalogController?catalogCategory=All%20Products'> Catalog </a>
            >
            <a href='CatalogController?productCode=<%= product.getProductCode()%>'> Item </a>
            <br>
            <br>
            <div class="bodytext">
                <table style="width:300px">
                    <tr>
                        <td>
                            <img src="<%=product.getImageURL()%>" alt="a" width="220" height="190">
                        </td>
                        <td>
                            <b>
                                <%=product.getProductName()%>
                            </b>
                            <br>
                            <i>
                                <%=product.getCatalogCategory()%>
                            </i>
                            <br>
                            <br>$<%=product.getPrice()%>
                            <br><br>
                            <form action="OrderController" method="GET">
                                <input type="hidden" name="action" value="updateCart">
                                <input type="hidden" name="productList" value="<%= product.getProductCode()%>"/>
                                <input type="Submit" value="Add to cart" />
                            </form>
                            <br>
                            <form action="CatalogController" method="GET">
                                <input type="hidden" name="catalogCategory" value="All Products">
                                <input type="submit" value="Return To Catalog" />
                            </form>
                        </td>
                    </tr>
                </table>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <p>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <%=product.getDescription()%>
                </p>
            </div>
        </div>
        <%@include file="/footer.jsp" %>
    </body>

</html>